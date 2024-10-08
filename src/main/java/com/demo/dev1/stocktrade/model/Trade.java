package com.demo.dev1.stocktrade.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Trade implements Serializable {
    private Long id;
    private String type;
    private User user;
    private String symbol;
    @Min(10)
    @Max(30)
    private Integer shares;
    @Min((long) 130.42)
    @Max((long) 195.65)
    private Float price;
    private Timestamp timestamp;

    private String message;

    public Trade() {
    }

    public Trade(String message) {
        this.message = message;
    }

    public Trade(Long id, String type, User user, String symbol, Integer quantity, Float price, Timestamp timestamp) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getShares() {
        return this.shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
