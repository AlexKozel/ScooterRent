package com.example.service;

import com.example.entity.LoginData;
import com.example.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BDUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(BDUserDetailsService.class);

    @Autowired
    private LoginDataService service;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("find loginData by login {}", s);
        LoginData loginData = service.findByLogin(s);
        if (loginData == null) {
            logger.warn("user {} not found", s);
            throw new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : loginData.getRoles()
        ) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        authorities.containsAll(loginData.getRoles());
        logger.info("find a roles {}", loginData.getRoles());
        return new User(loginData.getLogin(), loginData.getPassword(), authorities);
    }
}
