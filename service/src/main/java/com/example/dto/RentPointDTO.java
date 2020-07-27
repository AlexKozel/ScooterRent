package com.example.dto;

public class RentPointDTO extends AbstractDTO{

    private Integer rentPointId;
    private String coordinates;
    private String address;
    private String phone;
    private Integer cityId;

    public RentPointDTO() {
    }

    public Integer getRentPointId() {
        return rentPointId;
    }

    public void setRentPointId(Integer rentPointId) {
        setDtoId(rentPointId);
        this.rentPointId = rentPointId;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
