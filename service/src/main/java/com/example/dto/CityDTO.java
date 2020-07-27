package com.example.dto;

public class CityDTO extends AbstractDTO{

    private Integer cityId;
    private String cityName;

    public CityDTO() {
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        setDtoId(cityId);
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
