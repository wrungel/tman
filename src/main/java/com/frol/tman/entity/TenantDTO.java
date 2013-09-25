/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.frol.tman.entity;

import java.util.List;

/**
 *
 * @author maxx
 */
public class TenantDTO {
    private String firstName;
    private String middleName;
    private String secondName;
    private String birthDay;
    
    private List<PhoneNumber> phoneNumbers;

    public List<PhoneNumber> phoneNumbers() {
        return phoneNumbers;
    }
    
    public String birthDay() {
        return birthDay;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
