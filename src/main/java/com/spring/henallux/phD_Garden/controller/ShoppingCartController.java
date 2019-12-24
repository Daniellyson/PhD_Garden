package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Product;

import com.spring.henallux.phD_Garden.service.ProductService;
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

    @Autowired
    private ProductService productService;

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
            Model model,
            Locale locale) {

        //TODO appear message success

        try {
            Product product = productService.loadProduct(id);

            if(shoppingCart.get(product) != null) {
                shoppingCart.put(product, shoppingCart.get(product) + quantity);

                //TODO IF CUSTOMER LOGGED UPDATE ORDER

            } else {

                shoppingCart.put(product, quantity);

                //TODO IF CUSTOMER LOGGED UPDATE ORDER
            }

        } catch (Exception exception) {
            //TODO
            System.out.println("IN CATCH");
            return "redirect:" + origin;
        }


        return "redirect:" + origin;
    }

    @RequestMapping(value = "/withdraw/{id}", method= RequestMethod.GET)
    public String shoppingCart(
            @PathVariable("id") Integer id,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
            Locale locale) {
        Product product = productService.loadProduct(id);

        if(quantity == null) {

            shoppingCart.remove(product);

            //TODO IF LOGGED take off from order line
        } else {
            shoppingCart.put(product, shoppingCart.get(product) - quantity);

            //TODO IF LOGGED update from order line
        }


        return "redirect:/shopping-cart";
    }

}
