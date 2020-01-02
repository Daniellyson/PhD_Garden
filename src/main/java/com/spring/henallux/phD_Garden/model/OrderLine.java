package com.spring.henallux.phD_Garden.model;

import javax.validation.constraints.NotNull;

public class OrderLine {
    @NotNull
    private Integer id;

    @NotNull
    private Product product;

    @NotNull
    private Order order;

    @NotNull
    private double unitPrice;

    @NotNull
    private Integer quantity;

    public OrderLine() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
