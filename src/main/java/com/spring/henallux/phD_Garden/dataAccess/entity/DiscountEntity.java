package com.spring.henallux.phD_Garden.dataAccess.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="discount")
public class DiscountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer percentage;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
