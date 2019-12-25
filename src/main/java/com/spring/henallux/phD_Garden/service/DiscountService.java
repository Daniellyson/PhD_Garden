package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.DiscountDataAccess;
import com.spring.henallux.phD_Garden.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    @Qualifier("discountDAO")
    private DiscountDataAccess discountDAO;

    public List<Discount> getAllDiscountById(Integer id) {
        return discountDAO.getAllByDiscount(id);
    }

    public Discount getDiscountById(Integer id) {
        return discountDAO.getDiscountById(id);
    }
}
