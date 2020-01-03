package com.spring.henallux.phD_Garden.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class TranslationProduct implements Serializable {

    private Language language;
    private String product_name;
    private String description;
    private Product product;

    public TranslationProduct() {
    }

    public TranslationProduct(Language language, String product_name, String description, Product product) {
        this.language = language;
        this.product_name = product_name;
        this.description = description;
        this.product = product;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
