package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.model.Discount;
import com.spring.henallux.phD_Garden.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {

    public Double calculationTotalPrice(HashMap<Product, Integer> shoppingCart) {
        double totalPrice = 0.0;

        Collection<Product> keys = shoppingCart.keySet();
        for(Product key: keys){

            totalPrice += key.getPrice() * shoppingCart.get(key);
        }

        return totalPrice;
    }

    public Double calculationDiscount(Integer key, Double discount, HashMap<Product, Integer> shoppingCart) {
        double totalDiscount = 0.0;

        Collection<Product> products = shoppingCart.keySet();

        for (Product product : products) {

            if(product.getId() == key) {
                totalDiscount += product.getPrice() * discount * shoppingCart.get(product);
            }
        }
        return totalDiscount;
    }
}
