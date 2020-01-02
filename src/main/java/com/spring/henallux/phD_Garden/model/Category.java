package com.spring.henallux.phD_Garden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Integer id;
    private String urlImage;

    private List<TranslationCategory> translationCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<TranslationCategory> getTranslationCategory() {
        return translationCategory;
    }

    public void setTranslationCategory(List<TranslationCategory> translationCategory) {
        this.translationCategory = translationCategory;
    }
}
