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
    @Column
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
}
