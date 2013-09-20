package com.frol.tman.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Apartment apartment;

    @ManyToOne(optional = false)
    private Tenant mainTenant;

    @Temporal(TemporalType.DATE)
    Date contractBegin;

    @Temporal(TemporalType.DATE)
    Date contractEnd;

    @Temporal(TemporalType.DATE)
    Date realEnd;

    private Integer monthRate;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();


    private Integer securityDeposit;

    // ISO4217
    private String currency = "RU";

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Tenant getMainTenant() {
        return mainTenant;
    }

    public void setMainTenant(Tenant mainTenant) {
        this.mainTenant = mainTenant;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(Integer monthRate) {
        this.monthRate = monthRate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public Integer getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(Integer securityDeposit) {
        this.securityDeposit = securityDeposit;
    }
}
