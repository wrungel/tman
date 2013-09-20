package com.frol.tman.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Payment {

    @NotNull
    @Column(nullable = false)
    private Integer amount;

    @NotNull
    @Column(nullable = false)
    private String currency;

    @Temporal(TemporalType.DATE)
    private Date date;

    private boolean inCash;

    private String info;

    @ManyToOne(optional = false)
    private Rent rent;

    public boolean isInCash() {
        return inCash;
    }

    public void setInCash(boolean inCash) {
        this.inCash = inCash;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
