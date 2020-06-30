package com.example.service;

import com.example.dao.LoginDaoImpl;

import com.example.entity.LoginData;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Component
public class BDUserDetailsService implements UserDetailsService {

   @Autowired
   LoginDaoImpl loginDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       LoginData loginData =  loginDao.findByLogin(s);
       if(loginData == null){
           System.out.println("Login not found");
           throw new UsernameNotFoundException("User not found");
       }
//        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(loginData.getRoles().getAuthority()));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.containsAll( loginData.getRoles());
        return new User(loginData.getLogin(), loginData.getPassword(), authorities);
    }
}
