package com.spring.henallux.phD_Garden.dataAccess.repository;

import com.spring.henallux.phD_Garden.dataAccess.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer> {
    @Query(value = "SELECT p FROM DiscountEntity p WHERE p.productEntity.id = :id")
    List<DiscountEntity> findAllById(@Param("id") Integer id);

    List<DiscountEntity> findByStartDateBeforeAndEndDateAfterAndProductEntityId(Date startDate, Date endDate, Integer id);
}
