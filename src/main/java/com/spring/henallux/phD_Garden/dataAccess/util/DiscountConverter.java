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
        }

        return discount;
    }
}
