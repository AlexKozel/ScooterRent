package com.example.dto;

import lombok.Data;

@Data
public class UserDTO extends AbstractDTO{

    private Integer userId;
    private String firstName;
    private String secondName;
    private Integer discountId;
    private Integer loginDataId;

    public UserDTO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        setDtoId(userId);
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public Integer getLoginDataId() {
        return loginDataId;
    }

    public void setLoginDataId(int loginDataId) {
        this.loginDataId = loginDataId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "Id='" + userId + '\'' +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}