package com.spring.henallux.phD_Garden.model;

import com.spring.henallux.phD_Garden.exception.QuantityIsNegativeException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductCart {
    @NotNull
    private Product product;

    @Min(0)
    private Integer quantity;

    public ProductCart(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductCart() { }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) throws QuantityIsNegativeException {
        if (quantity <= 0)
            throw new QuantityIsNegativeException();
        this.quantity = quantity;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(Integer quantity) throws QuantityIsNegativeException {
        if (this.quantity-quantity <= 0)
            throw new QuantityIsNegativeException();

        this.quantity -= quantity;
    }
}
