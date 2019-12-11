package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.CategoryDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.dao.CategoryDAO;
import com.spring.henallux.phD_Garden.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryService {

    @Autowired
    @Qualifier("categoryDAO")
    private CategoryDataAccess categoryDAO;

    /*@Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }*/

    public Collection<Category> getAllCategories(){
        return categoryDAO.getAll();
    }

    public Category loadCategory(Integer id) {

        return categoryDAO.getById(id);
    }
}
