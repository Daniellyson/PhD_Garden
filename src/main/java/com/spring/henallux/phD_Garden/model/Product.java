package com.spring.henallux.phD_Garden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
public class Product {
    private Integer id;
    private Double price;
    private String url_image;
    private Integer stock;

    @NotEmpty
    private List<TranslationProduct> translationProducts;

    private List<Discount> discounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<TranslationProduct> getTranslationProducts() {
        return translationProducts;
    }

    public void setTranslationProducts(List<TranslationProduct> translationProducts) {
        this.translationProducts = translationProducts;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
