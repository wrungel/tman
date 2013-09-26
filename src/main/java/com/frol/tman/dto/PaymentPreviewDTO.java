package com.frol.tman.dto;

import java.util.Date;

public class PaymentPreviewDTO {

    private Long id;

    private Integer amount;

    private Date date;

    private boolean inCash;

    private String info;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
}
