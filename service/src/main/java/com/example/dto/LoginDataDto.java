package com.example.dto;

import com.example.entity.Role;

import java.util.List;

public class LoginDataDto extends AbstractDTO{

    private Integer loginId;
    private String login;
    private String password;
    private List<Integer> roles;

    public LoginDataDto(){}

    @Override
    public String toString() {
        return "LoginDataDto{" +
                "loginId=" + loginId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getLoginId() {
        return loginId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginId(Integer loginId) {
        setDtoId(loginId);
        this.loginId = loginId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        for (Role role: roles
             ) {this.roles.add(role.getRoleId());
        }
    }
}
