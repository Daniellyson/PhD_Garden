package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.model.Product;

import com.spring.henallux.phD_Garden.model.TranslationCategory;
import com.spring.henallux.phD_Garden.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/add/{id}", method= RequestMethod.GET)
    public String shoppingCart(
            @PathVariable("id") Integer id,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("origin") String origin,
            @ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
            //@ModelAttribute(value = Constants.MESSAGE) MessageQueue messageQueue,
            Locale locale) {
        //Product product = productService.loadProduct(id);



        return "redirect:" + origin;
    }
}
