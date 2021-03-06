package com.spring.henallux.phD_Garden.dataAccess.util;

import com.spring.henallux.phD_Garden.dataAccess.entity.CategoryEntity;
import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.model.TranslationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    @Autowired
    private LanguageConverter languageConverter;

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        Category category = new Category();

        category.setId(categoryEntity.getId());
        category.setUrlImage(categoryEntity.getUrlImage());
        category.setTranslationCategory(categoryEntity.getTranslationCategoryEntity()
                .stream()
                .map(translationCategoryEntity -> new TranslationCategory
                        (languageConverter.languageEntityToLanguageModel(translationCategoryEntity.getTranslationCategoryLanguageEntityID()),
                                translationCategoryEntity.getCategory_name()))
                .collect(Collectors.toList()));

        return category;
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setUrlImage(category.getUrlImage());

        return categoryEntity;
    }
}
