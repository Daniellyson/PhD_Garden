package com.spring.henallux.phD_Garden.dataAccess;

import com.spring.henallux.phD_Garden.model.OrderLine;

public interface IOrderLineDataAccess {
    OrderLine save(OrderLine orderLine);
}
