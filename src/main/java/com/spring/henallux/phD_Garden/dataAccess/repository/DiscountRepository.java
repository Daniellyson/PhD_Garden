package com.spring.henallux.phD_Garden.dataAccess.repository;

import com.spring.henallux.phD_Garden.dataAccess.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer> {
}
