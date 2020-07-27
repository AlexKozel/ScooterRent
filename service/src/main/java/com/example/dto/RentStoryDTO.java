package com.example.dto;

public class RentStoryDTO extends AbstractDTO{

    private Integer rentStoryId;
    private Integer rentDuration;
    private Integer Money;
    private String paidWay;
    private Integer userId;
    private Integer scooterId;

    public RentStoryDTO() {
    }

    public Integer getRentStoryId() {
        return rentStoryId;
    }

    public void setRentStoryId(int rentStoryId) {
        setDtoId(rentStoryId);
        this.rentStoryId = rentStoryId;
    }

    public Integer getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(Integer rentDuration) {
        this.rentDuration = rentDuration;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    public String getPaidWay() {
        return paidWay;
    }

    public void setPaidWay(String paidWay) {
        this.paidWay = paidWay;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }
}
