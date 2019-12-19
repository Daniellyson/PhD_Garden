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
@AllArgsConstructor
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
}
