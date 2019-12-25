package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.model.Discount;
import com.spring.henallux.phD_Garden.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public double getOrderSubtotal() {
        return 0.0;
    }

    public String calculationDiscount(HashMap<Integer, Discount> discounts, HashMap<Product, Integer> shoppingCart) {
        double totalDiscount = 0.0;

        Collection<Product> products = shoppingCart.keySet();

        for (Map.Entry entry : discounts.entrySet()) {
            double percentage = (double)entry.getValue() / 100;
            for (Product product : products) {
                if(product.getId() == entry.getKey()) {
                    totalDiscount += product.getPrice() * percentage;
                }
            }
        }
        return String.format("%.2f", totalDiscount);
    }
}
