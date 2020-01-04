package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.exception.QuantityException;
import com.spring.henallux.phD_Garden.model.Product;

import com.spring.henallux.phD_Garden.service.ProductService;
import com.spring.henallux.phD_Garden.service.ShoppingCartService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value="/shopping-cart")
public class ShoppingCartController extends BaseController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    private Double discountTotal = 0.0;

    @Getter
    private HashMap<Integer, Double> discounts = new HashMap<>();

    @RequestMapping(method= RequestMethod.GET)
    public String shoppingCart(@ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
                               Model model,
                               Locale locale) {

        model.addAttribute("title", getMessageSource().getMessage("shoppingCart", null, locale));
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("categories", categories());

        try {
            Double orderSubtotal = shoppingCartService.calculationTotalPrice(shoppingCart);

            model.addAttribute("orderSubtotal", String.format("%.2f", orderSubtotal));

            for (Map.Entry entry : discounts.entrySet()) {
                discountTotal += shoppingCartService.calculationDiscount((Integer) entry.getKey(), (Double)entry.getValue(), shoppingCart);
            }
            model.addAttribute("discount", String.format("%.2f", discountTotal));

            Double totalOrder = orderSubtotal - discountTotal;
            model.addAttribute("totalOrder", String.format("%.2f",totalOrder));

            discountTotal = 0.0;

            return "integrated:shopping-cart";
        }catch (QuantityException q ) {
            return "integrated:shopping-cart";
        }

    }

    @RequestMapping(value = "/add/{id}", method= RequestMethod.GET)
    public String shoppingCart(
            @PathVariable("id") Integer id,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("origin") String origin,
            @RequestParam(value = "percentage", required = false) Integer discount,
            @ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
            Model model,
            Locale locale) {

        Product product = productService.loadProduct(id);

        if(shoppingCart.get(product) != null) {
            shoppingCart.put(product, shoppingCart.get(product) + quantity);
        } else {

            shoppingCart.put(product, quantity);
        }

        if(id != null && discount != null) {
            if(!discounts.containsKey(id)) {
                Double percentage = (discount/100.0);
                discounts.put(id, percentage);
            }
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

        } else {
            shoppingCart.put(product, shoppingCart.get(product) - quantity);
        }

        return "redirect:/shopping-cart";
    }

}