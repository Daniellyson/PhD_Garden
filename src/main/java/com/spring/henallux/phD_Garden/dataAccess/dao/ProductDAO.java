package com.spring.henallux.phD_Garden.dataAccess.dao;

import com.spring.henallux.phD_Garden.dataAccess.ProductDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.repository.ProductRepository;
import com.spring.henallux.phD_Garden.dataAccess.util.ProductConverter;
import com.spring.henallux.phD_Garden.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDAO implements ProductDataAccess {

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public List<Product> getAllByCategory(Integer categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream()
                .map(productConverter::productEntityToProductModel).collect(Collectors.toList());
    }

    @Override
    public Product getById(Integer id) {
        return productConverter.productEntityToProductModel(productRepository.findById(id).orElse(null));
    }


}
