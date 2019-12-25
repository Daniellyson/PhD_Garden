package com.spring.henallux.phD_Garden.dataAccess.dao;

import com.spring.henallux.phD_Garden.dataAccess.CategoryDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.repository.CategoryRepository;
import com.spring.henallux.phD_Garden.dataAccess.util.CategoryConverter;
import com.spring.henallux.phD_Garden.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryDAO implements CategoryDataAccess {

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }


    @Override
    public Collection<Category> getAll() {
        return categoryRepository.findAll().stream().map(
                categoryEntity -> categoryConverter.categoryEntityToCategoryModel(categoryEntity)).collect(Collectors.toList());
    }

    @Override
    public Category getById(Integer id) {
        return categoryConverter.categoryEntityToCategoryModel(categoryRepository.findById(id).orElse(null));
    }
}
