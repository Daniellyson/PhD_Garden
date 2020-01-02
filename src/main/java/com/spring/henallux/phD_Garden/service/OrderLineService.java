package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.IOrderLineDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.phD_Garden.model.OrderLine;
import com.spring.henallux.phD_Garden.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {
    private IOrderLineDataAccess orderLineDAO;
    private ProductService productService;

    @Autowired
    public OrderLineService(OrderLineDAO orderLineDAO,
                            ProductService productService) {
        this.orderLineDAO = orderLineDAO;
        this.productService = productService;
    }

    public OrderLine save(OrderLine orderLine) {
        return this.orderLineDAO.save(orderLine);
    }

    public Double getPrice(Integer quantity, Product product) {
        return product.getPrice() * (double)quantity;
    }
}
