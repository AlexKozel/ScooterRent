package com.example.dto;

public class SeasonTicketDTO extends AbstractDTO{

    private Integer seasonTicketId;
    private Integer hoursLeft;
    private Integer costPerHour;
    private Integer UserId;

    public SeasonTicketDTO() {
    }

    public Integer getSeasonTicketId() {
        return seasonTicketId;
    }

    public void setSeasonTicketId(int seasonTicketId) {
        setDtoId(seasonTicketId);
        this.seasonTicketId = seasonTicketId;
    }

    public Integer getHoursLeft() {
        return hoursLeft;
    }

    public void setHoursLeft(int hoursLeft) {
        this.hoursLeft = hoursLeft;
    }

    public Integer getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
