package com.example.dto;


public class DiscountDTO extends AbstractDTO{

    private Integer discountId;
    private Integer discountRate;
    private Integer userId;

    public DiscountDTO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        setDtoId(discountId);
        this.discountId = discountId;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "DiscountDTO{" +
                "discountId=" + discountId +
                ", discountRate=" + discountRate +
                ", userId=" + userId +
                '}';
    }
}
