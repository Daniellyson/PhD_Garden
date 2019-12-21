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

    public Boolean isAvailable() {
        return stock > 0;
    }
}
