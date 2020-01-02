package com.spring.henallux.phD_Garden.dataAccess.entity;

import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.model.TranslationProduct;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    private Double price;
    private Integer stock;
    private String url_image;

    @OneToMany(mappedBy = "translationProductEntityID")
    private List<TranslationProductEntity> translationProductsEntity;

    @OneToMany(mappedBy = "id")
    private List<DiscountEntity> discounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public List<TranslationProductEntity> getTranslationProductsEntity() {
        return translationProductsEntity;
    }

    public void setTranslationProductsEntity(List<TranslationProductEntity> translationProductsEntity) {
        this.translationProductsEntity = translationProductsEntity;
    }

    public List<DiscountEntity> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountEntity> discounts) {
        this.discounts = discounts;
    }
}
