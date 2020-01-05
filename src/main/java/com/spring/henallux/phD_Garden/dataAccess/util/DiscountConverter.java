package com.spring.henallux.phD_Garden.dataAccess.util;

import com.spring.henallux.phD_Garden.dataAccess.entity.DiscountEntity;
import com.spring.henallux.phD_Garden.model.Discount;
import org.springframework.stereotype.Component;

@Component
public class DiscountConverter {

    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity) {
        Discount discount = null;

        if(discountEntity != null) {
            discount = new Discount();

            discount.setId(discountEntity.getId());
            discount.setPercentage(discountEntity.getPercentage());
            discount.setStartDate(discountEntity.getStartDate());
            discount.setEndDate(discountEntity.getEndDate());
            discount.setProduct(ProviderConverter.productEntityToProductModel(discountEntity.getProductEntity()));
        }

        return discount;
    }

    public DiscountEntity discountModelToDiscountEntity(Discount discount) {
        DiscountEntity discountEntity = null;

        if(discountEntity != null) {
            discountEntity = new DiscountEntity();

            discountEntity.setId(discount.getId());
            discountEntity.setPercentage(discount.getPercentage());
            discountEntity.setStartDate(discount.getStartDate());
            discountEntity.setEndDate(discount.getEndDate());
            discountEntity.setProductEntity(ProviderConverter.productModelToProductEntity(discount.getProduct()));
        }

        return discountEntity;
    }
}
