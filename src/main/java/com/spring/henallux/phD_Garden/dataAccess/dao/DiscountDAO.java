package com.spring.henallux.phD_Garden.dataAccess.dao;


import com.spring.henallux.phD_Garden.dataAccess.DiscountDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.repository.DiscountRepository;
import com.spring.henallux.phD_Garden.dataAccess.util.DiscountConverter;
import com.spring.henallux.phD_Garden.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountDAO implements DiscountDataAccess {
    private DiscountRepository discountRepository;
    private DiscountConverter discountConverter;

    @Autowired
    public DiscountDAO(DiscountRepository discountRepository, DiscountConverter discountConverter) {
        this.discountRepository = discountRepository;
        this.discountConverter = discountConverter;
    }


    @Override
    public List<Discount> getAllByDiscount(Integer id) {
        return discountRepository.findAllById(id).stream()
                .map(discountEntity -> discountConverter.discountEntityToDiscountModel(discountEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Discount getDiscountById(Integer id) {
        return discountConverter.discountEntityToDiscountModel(discountRepository.findById(id).orElse(null));
    }
}
