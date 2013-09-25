package com.frol.tman.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;

@Embeddable
public class PhoneNumber {


    @Digits(integer = 3, fraction = 0)
    private String countryCode;

    @Digits(integer = 20, fraction = 0)
    private String areaCode;

    @Digits(integer = 20, fraction = 0)
    private String number;


    private PhoneType type;

    protected PhoneNumber() {

    }

    public PhoneNumber(String countryCode, String areaCode, String number, PhoneType type) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
        this.type = type;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getType() {
        return type;
    }
}
