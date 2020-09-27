package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.model.Discount;
import com.spring.henallux.phD_Garden.model.Product;
import com.spring.henallux.phD_Garden.service.CategoryService;
import com.spring.henallux.phD_Garden.service.DiscountService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Controller
@SessionAttributes({Constants.SHOPPING_CART})
public class BaseController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DiscountService discountService;

    @ModelAttribute(Constants.SHOPPING_CART)
    public HashMap<Product, Integer> shoppingCart() {
        return new HashMap<Product, Integer>();
    }

    /*@ModelAttribute(Constants.DISCOUNTS)
    public HashMap<Integer, Discount> discount() {
        return new HashMap<Integer, Discount>();
    }*/

    public List<Category> categories() {
       return (List<Category>)categoryService.getAllCategories();
    }

}
