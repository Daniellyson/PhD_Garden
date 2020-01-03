package com.spring.henallux.phD_Garden.dataAccess.dao;

import com.spring.henallux.phD_Garden.dataAccess.IOrderDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.entity.OrderEntity;
import com.spring.henallux.phD_Garden.dataAccess.repository.OrderRepository;
import com.spring.henallux.phD_Garden.dataAccess.util.ProviderConverter;
import com.spring.henallux.phD_Garden.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDAO implements IOrderDataAccess {

    private OrderRepository orderRepository;

    @Autowired
    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(OrderEntity orderEntity) {
        OrderEntity orderEntitySaved = this.orderRepository.save(orderEntity);
        return ProviderConverter.orderEntityToOrderModel(orderEntitySaved);
    }
}
