package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class ShoppingCartService {

    public String calculationTotalPrice(HashMap<Product, Integer> shoppingCart) {
        double totalPrice = 0.0;

        Collection<Product> keys = shoppingCart.keySet();
        for(Product key: keys){

            totalPrice += key.getPrice() * shoppingCart.get(key);
        }

        return String.format("%.2f", totalPrice);
    }

}
