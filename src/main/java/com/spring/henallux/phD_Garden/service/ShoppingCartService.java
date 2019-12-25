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

    public String calculationDiscount(Integer key, Integer discount, HashMap<Product, Integer> shoppingCart) {
        double totalDiscount = 0.0;
        System.out.println("IN CALC DISCOUNT");

        Collection<Product> products = shoppingCart.keySet();

        double percentage = (double)discount / 100;

        for (Product product : products) {
            if(product.getId() == key) {
                totalDiscount += product.getPrice() * percentage * shoppingCart.get(product);
            }
        }
        System.out.println("DISCOUNT : " + totalDiscount);
        return String.format("%.2f", totalDiscount);
    }
}
