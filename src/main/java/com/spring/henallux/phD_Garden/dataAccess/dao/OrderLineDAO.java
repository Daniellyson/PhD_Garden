package com.spring.henallux.phD_Garden.dataAccess.dao;

import com.spring.henallux.phD_Garden.dataAccess.IOrderLineDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.phD_Garden.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.phD_Garden.dataAccess.util.ProviderConverter;
import com.spring.henallux.phD_Garden.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderLineDAO implements IOrderLineDataAccess {

    private OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineDAO(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public OrderLine save(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = new ProviderConverter().orderLineModelToOrderLineEntity(orderLine);
        OrderLineEntity newOrderLineEntity = this.orderLineRepository.save(orderLineEntity);
        return new ProviderConverter().orderLineEntityToOrderLineModel(newOrderLineEntity);
    }
}
