package com.spring.henallux.phD_Garden.dataAccess.entity;

import com.spring.henallux.phD_Garden.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Embeddable
@Table(name="translation_product")
@NoArgsConstructor
public class TranslationProductEntity implements Serializable {

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity translationProductEntityID;

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity translationProductLanguageEntityID;

    private String product_name;
    private String description;

    public TranslationProductEntity(ProductEntity translationProductEntityID, LanguageEntity translationProductLanguageEntityID, String product_name, String description) {
        this.translationProductEntityID = translationProductEntityID;
        this.translationProductLanguageEntityID = translationProductLanguageEntityID;
        this.product_name = product_name;
        this.description = description;
    }

    public ProductEntity getTranslationProductEntityID() {
        return translationProductEntityID;
    }

    public void setTranslationProductEntityID(ProductEntity translationProductEntityID) {
        this.translationProductEntityID = translationProductEntityID;
    }

    public LanguageEntity getTranslationProductLanguageEntityID() {
        return translationProductLanguageEntityID;
    }

    public void setTranslationProductLanguageEntityID(LanguageEntity translationProductLanguageEntityID) {
        this.translationProductLanguageEntityID = translationProductLanguageEntityID;
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
}
