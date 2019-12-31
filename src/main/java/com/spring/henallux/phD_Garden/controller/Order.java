package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Product;
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
@RequestMapping(value="/order")
public class Order extends BaseController {


    @RequestMapping(method= RequestMethod.GET)
    public String order(@ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
            Model model,
            Locale locale) {

        model.addAttribute("categories", categories());

        //TODO conditions

        model.addAttribute("title", getMessageSource().getMessage("checkOut", null, locale));
        model.addAttribute("locale", locale.getLanguage());
        //TODO total
        model.addAttribute("total", "value fictitious : 100 €");

        return "integrated:order";
    }
}
