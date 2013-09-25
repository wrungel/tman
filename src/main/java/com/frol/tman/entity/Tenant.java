package com.frol.tman.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tenant {

    @Id
    private String id;

    private String firstName;
    private String middleName;
    private String secondName;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ElementCollection
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
