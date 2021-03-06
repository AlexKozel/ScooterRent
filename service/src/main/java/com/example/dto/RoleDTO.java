package com.example.dto;

public class RoleDTO extends AbstractDTO{

    private Integer roleId;
    private String name;

    public RoleDTO() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        setDtoId(roleId);
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
