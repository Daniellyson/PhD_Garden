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
    private CategoryEntity category;

    private Double price;
    private Integer stock;
    private String url_image;

    @OneToMany(mappedBy = "translationProductEntityID")
    private List<TranslationProductEntity> translationProductsEntity;
}
