package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.IOrderDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.IOrderLineDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.dao.OrderDAO;
import com.spring.henallux.phD_Garden.dataAccess.util.ProviderConverter;
import com.spring.henallux.phD_Garden.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private IOrderDataAccess orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order create(Order order) {
        return this.orderDAO.create(ProviderConverter.orderModelToOrderEntity(order));
    }
}
