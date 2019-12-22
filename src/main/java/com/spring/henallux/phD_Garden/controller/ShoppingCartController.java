package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.model.Product;

import com.spring.henallux.phD_Garden.model.TranslationCategory;
import com.spring.henallux.phD_Garden.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="/shopping-cart")
public class ShoppingCartController extends BaseController{

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(method= RequestMethod.GET)
    public String shoppingCart(@ModelAttribute(value = "shoppingCart") HashMap<Product, Integer> shoppingCart, Model model, Locale locale) {
        model.addAttribute("title", getMessageSource().getMessage("shoppingCart", null, locale));
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("categories", categories());


        return "integrated:shopping-cart";
    }
}
