package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.exception.QuantityException;
import com.spring.henallux.phD_Garden.model.Product;
import com.spring.henallux.phD_Garden.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value="/order")
public class OrderController extends BaseController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartController shoppingCartController;

    private Double discountTotal = 0.0;

    @RequestMapping(method= RequestMethod.GET)
    public String order(@ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
                        Model model,
                        Locale locale,
                        Authentication authentication) {

        if(shoppingCart.isEmpty()) {
            return "integrated:/ShoppingCart";
        }

        try {
            Double orderSubtotal = shoppingCartService.calculationSubtotal(shoppingCart);

            for (Map.Entry entry : shoppingCartController.getDiscounts().entrySet()) {
                discountTotal += shoppingCartService.calculationDiscount((Integer) entry.getKey(), (Double)entry.getValue(), shoppingCart);
            }

            shoppingCartService.saveCart(shoppingCart, authentication);

            Double totalOrder = orderSubtotal - discountTotal;
            if(totalOrder < 1) totalOrder = 1.0;
            model.addAttribute("totalOrder", String.format("%.2f",totalOrder));
            model.addAttribute("totalPayPal", totalOrder);


            model.addAttribute("title", getMessageSource().getMessage("checkOut", null, locale));
            model.addAttribute("locale", locale.getLanguage());
            model.addAttribute("categories", categories());

            discountTotal = 0.0;

            return "integrated:order";
        }catch (QuantityException q) {
            return "integrated:order";
        }

    }

    @RequestMapping(value = "/canceled", method= RequestMethod.GET)
    public String canceledOrder() {

        return "redirect:/order";
    }
}
