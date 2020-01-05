package com.spring.henallux.phD_Garden.dataAccess;

import com.spring.henallux.phD_Garden.model.Product;

import java.util.List;

public interface ProductDataAccess {
    List<Product> getAllByCategory(Integer categoryId);

    Product getById(Integer id);

    void updateStock(Integer newStock, Integer id);
}
