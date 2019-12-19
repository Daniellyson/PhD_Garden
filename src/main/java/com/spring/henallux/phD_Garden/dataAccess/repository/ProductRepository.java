package com.spring.henallux.phD_Garden.dataAccess.repository;

import com.spring.henallux.phD_Garden.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    //TODO TO FIX @QUERY
    @Query(value = "SELECT p FROM ProductEntity p WHERE p.category.id = id")
    List<ProductEntity> findAllByCategoryId(@Param("id") Integer id);
}
