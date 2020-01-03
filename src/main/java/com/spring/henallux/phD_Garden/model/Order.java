package com.spring.henallux.phD_Garden.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Order {
    @NotNull
    private Integer id;

    @NotNull
    private User user;

    @NotNull
    private Date orderDate;

    @NotNull
    private Boolean paid;

    public Order() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
