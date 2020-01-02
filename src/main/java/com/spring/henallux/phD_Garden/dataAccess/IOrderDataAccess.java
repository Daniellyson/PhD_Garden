package com.spring.henallux.phD_Garden.dataAccess;

import com.spring.henallux.phD_Garden.dataAccess.entity.OrderEntity;
import com.spring.henallux.phD_Garden.model.Order;

public interface IOrderDataAccess {
    Order create(OrderEntity orderEntity);
}
