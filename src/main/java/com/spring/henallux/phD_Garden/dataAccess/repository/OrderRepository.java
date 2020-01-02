package com.spring.henallux.phD_Garden.dataAccess.repository;

import com.spring.henallux.phD_Garden.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
