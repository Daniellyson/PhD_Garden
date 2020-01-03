package com.spring.henallux.phD_Garden.dataAccess.util;

import com.spring.henallux.phD_Garden.dataAccess.entity.ProductEntity;
import com.spring.henallux.phD_Garden.dataAccess.entity.TranslationProductEntity;
import com.spring.henallux.phD_Garden.model.Product;
import com.spring.henallux.phD_Garden.model.TranslationProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductConverter {

    @Autowired
    private LanguageConverter languageConverter;

    public Product productEntityToProductModel(ProductEntity productEntity) {
        Product product = null;

        if(productEntity != null) {
            product = new Product();

            product.setId(productEntity.getId());
            product.setPrice(productEntity.getPrice());
            product.setStock(productEntity.getStock());
            product.setUrl_image(productEntity.getUrl_image());
            product.setTranslationProducts(productEntity.getTranslationProductsEntity()
                    .stream()
                    .map(translationProductEntity -> new TranslationProduct
                            (languageConverter.languageEntityToLanguageModel(translationProductEntity.getTranslationProductLanguageEntityID()),
                                    translationProductEntity.getProduct_name(), translationProductEntity.getDescription()))
                    .collect(Collectors.toList()));
        }

        return product;
    }

    public ProductEntity productModelToProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();


        productEntity.setStock(product.getStock());


        return productEntity;
    }
}
