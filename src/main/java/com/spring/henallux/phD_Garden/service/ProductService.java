package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.ProductDataAccess;
import com.spring.henallux.phD_Garden.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    @Qualifier("productDAO")
    private ProductDataAccess productDAO;

    public List<Product> loadAllProductsByCategory(Integer categoryId) {
        return productDAO.getAllByCategory(categoryId);
    }

    public Product loadProduct(Integer id) {
        return productDAO.getById(id);
    }

    public void updateStock(Integer newStock, Integer id) {
        productDAO.updateStock(newStock, id);
    }

}
