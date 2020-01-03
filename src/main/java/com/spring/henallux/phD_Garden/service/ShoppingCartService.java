package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.entity.UserEntity;
import com.spring.henallux.phD_Garden.dataAccess.util.ProviderConverter;
import com.spring.henallux.phD_Garden.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {

    private OrderService orderService;
    private OrderLineService orderLineService;
    private DiscountService discountService;

    @Autowired
    public ShoppingCartService(OrderService orderService,
                       OrderLineService orderLineService,
                       DiscountService discountService) {
        this.orderService = orderService;
        this.orderLineService = orderLineService;
        this.discountService = discountService;
    }

    @Transactional
    public void saveCart(HashMap<Product, Integer> cart,
                         Authentication authentication) {
        Order order = new Order();
        order.setUser((User) authentication.getPrincipal());
        order.setOrderDate(new Date());
        order.setPaid(false);
        Order createdOrder = this.orderService.create(order);

        for (Map.Entry<Product, Integer> cartItem : cart.entrySet()) {
            Product item = cartItem.getKey();

            OrderLine orderLine = new OrderLine();
            orderLine.setProduct(item);
            orderLine.setOrder(createdOrder);
            orderLine.setQuantity(cartItem.getValue());
            orderLine.setUnitPrice(item.getPrice());
            this.orderLineService.save(orderLine);
        }
    }

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
