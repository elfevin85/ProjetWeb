package com.example.demothymeleaf.Service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class CountryDTO implements Serializable {

    private Long countryId;
    private String country;
    private java.sql.Timestamp lastUpdate;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString(){
        return "CountryDTO{" +
                "countryId=" + countryId +
                ", country =" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
