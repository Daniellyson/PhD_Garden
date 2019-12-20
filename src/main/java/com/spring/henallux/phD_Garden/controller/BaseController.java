package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.LuhnCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Controller
public class BaseController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CategoryService categoryService;

    public List<Category> categories() {
       return (List<Category>)categoryService.getAllCategories();
    }

}
