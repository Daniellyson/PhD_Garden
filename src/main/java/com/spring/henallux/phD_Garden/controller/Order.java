package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Product;
import com.spring.henallux.phD_Garden.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value="/order")
public class Order extends BaseController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartController shoppingCartController;

    private Double discountTotal = 0.0;

    @RequestMapping(method= RequestMethod.GET)
    public String order(@ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
                        Model model,
                        Locale locale) {

        Double orderSubtotal = shoppingCartService.calculationTotalPrice(shoppingCart);

        for (Map.Entry entry : shoppingCartController.getDiscounts().entrySet()) {
            discountTotal += shoppingCartService.calculationDiscount((Integer) entry.getKey(), (Double)entry.getValue(), shoppingCart);
        }

        Double totalOrder = orderSubtotal - discountTotal;
        model.addAttribute("totalOrder", String.format("%.2f",totalOrder));


        model.addAttribute("title", getMessageSource().getMessage("checkOut", null, locale));
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("categories", categories());

        discountTotal = 0.0;

        return "integrated:order";
    }
}
