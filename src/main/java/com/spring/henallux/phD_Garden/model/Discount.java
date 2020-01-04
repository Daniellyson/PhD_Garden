package com.spring.henallux.phD_Garden.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
public class Discount {

    private Integer id;
    private Integer percentage;
    private Date startDate;
    private Date endDate;
    private Product product;

    public Discount(Integer id, Integer percentage, Date startDate, Date endDate, Product product) {
        this.id = id;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
