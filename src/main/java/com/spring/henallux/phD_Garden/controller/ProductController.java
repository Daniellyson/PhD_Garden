package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Discount;
import com.spring.henallux.phD_Garden.model.Product;
import com.spring.henallux.phD_Garden.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value="/products_Category")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public String product(@PathVariable("id") Integer id,
                          //@ModelAttribute(value = Constants.SHOPPING_CART) HashMap<Product, Integer> shoppingCart,
                          Model model,
                          Locale locale) {

        model.addAttribute("title", getMessageSource().getMessage("productbyCategory", null, locale));
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("currentCategory", getCategoryService().loadCategory(id));

        model.addAttribute("categories", categories());

        model.addAttribute("products", productService.loadAllProductsByCategory(id));

        return "integrated:product";
    }

}
