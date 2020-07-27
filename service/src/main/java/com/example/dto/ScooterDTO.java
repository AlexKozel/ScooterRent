package com.example.dto;

public class ScooterDTO extends AbstractDTO{

    private Integer scooterId;
    private String model;
    private String status;
    private Integer RentPointId;

    public ScooterDTO() {
    }

    public Integer getScooterId() {
        return scooterId;
    }

    public void setScooterId(Integer scooterId) {
        setDtoId(scooterId);
        this.scooterId = scooterId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRentPointId() {
        return RentPointId;
    }

    public void setRentPointId(int rentPointId) {
        RentPointId = rentPointId;
    }
}
