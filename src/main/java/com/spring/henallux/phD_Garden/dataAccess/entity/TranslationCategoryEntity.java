package com.spring.henallux.phD_Garden.dataAccess.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Embeddable
@Table(name="translation_category")
public class TranslationCategoryEntity implements Serializable {

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntityID;

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity languageEntityID;

    private String category_name;
}
