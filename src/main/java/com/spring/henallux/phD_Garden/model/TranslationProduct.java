package com.spring.henallux.phD_Garden.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TranslationProduct implements Serializable {

    private Language language;
    private String product_name;
    private String description;
}
