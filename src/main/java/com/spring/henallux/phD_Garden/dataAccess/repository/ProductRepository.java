package com.spring.henallux.phD_Garden.dataAccess.repository;

import com.spring.henallux.phD_Garden.dataAccess.entity.ProductEntity;
import com.spring.henallux.phD_Garden.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query(value = "SELECT p FROM ProductEntity p WHERE p.categoryEntity.id = :id")
    List<ProductEntity> findAllByCategoryId(@Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE ProductEntity SET stock = :newStock WHERE id = :id")
    void updateStock(@Param("newStock") Integer newStock,@Param("id") Integer id);
}
