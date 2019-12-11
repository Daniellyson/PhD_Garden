package com.spring.henallux.phD_Garden.dataAccess.util;

import com.spring.henallux.phD_Garden.dataAccess.entity.CategoryEntity;
import com.spring.henallux.phD_Garden.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setUrlImage(category.getUrlImage());

        return categoryEntity;
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        Category category = new Category();

        category.setUrlImage(categoryEntity.getUrlImage());

        return  category;
    }
}
