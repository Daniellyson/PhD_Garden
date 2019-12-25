package com.spring.henallux.phD_Garden.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
public class Discount {

    private Integer id;
    private Integer percentage;
    private Date startDate;
    private Date endDate;

}
