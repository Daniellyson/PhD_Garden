package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Product;
import com.spring.henallux.phD_Garden.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

        Double orderSubtotal = shoppingCartService.calculationTotalPrice(shoppingCart);

        for (Map.Entry entry : shoppingCartController.getDiscounts().entrySet()) {
            discountTotal += shoppingCartService.calculationDiscount((Integer) entry.getKey(), (Double)entry.getValue(), shoppingCart);
        }

        shoppingCartService.saveCart(shoppingCart, authentication);

        Double totalOrder = orderSubtotal - discountTotal;
        model.addAttribute("totalOrder", String.format("%.2f",totalOrder));
        model.addAttribute("totalPayPal", totalOrder);


        model.addAttribute("title", getMessageSource().getMessage("checkOut", null, locale));
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("categories", categories());

        discountTotal = 0.0;

        shoppingCart = new HashMap<>();

        return "integrated:order";
    }

    //TODO success paid
    @RequestMapping(value = "/succeed", method= RequestMethod.GET)
    public String successOrder(
            @ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
            Locale locale) {



        shoppingCart.clear();

        return "redirect:/";
    }

    //TODO not paid canceledOrder
    @RequestMapping(value = "/canceled", method= RequestMethod.GET)
    public String canceledOrder() {

        return "redirect:/order";
    }
}
