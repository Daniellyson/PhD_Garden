package com.spring.henallux.phD_Garden.dataAccess.repository;

import com.spring.henallux.phD_Garden.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {
}
