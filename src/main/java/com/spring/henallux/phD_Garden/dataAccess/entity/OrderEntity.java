package com.spring.henallux.phD_Garden.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "customer_order")
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "paid")
    private Boolean isPaid;

    public OrderEntity() { }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}

