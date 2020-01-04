package com.spring.henallux.phD_Garden.dataAccess;

import com.spring.henallux.phD_Garden.model.Discount;

import java.util.Date;
import java.util.List;

public interface DiscountDataAccess {

    List<Discount> getAllByDiscount(Integer id);

    List<Discount> getAllByDiscount(Date currentDate, Integer id);

    Discount getDiscountById(Integer id);
}
