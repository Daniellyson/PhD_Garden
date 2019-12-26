package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.DiscountDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Discount;
import com.spring.henallux.phD_Garden.model.Product;
import com.spring.henallux.phD_Garden.model.TranslationProduct;
import com.spring.henallux.phD_Garden.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping(value="/products_Category")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public String product(@PathVariable("id") Integer id,
                          @ModelAttribute(value = Constants.DISCOUNTS) HashMap<Integer, Discount> discounts,
                          Model model,
                          RedirectAttributes redirectAttributes,
                          Locale locale) {

        model.addAttribute("title", getMessageSource().getMessage("productbyCategory", null, locale));
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("currentCategory", getCategoryService().loadCategory(id));

        model.addAttribute("categories", categories());

        List<Product> products = productService.loadAllProductsByCategory(id);
        model.addAttribute("products", products);


        for (Product product : products) {
            List<Discount> discountList = getDiscountService().getAllDiscountById(product.getId());
            for (Discount discount : discountList) {
                if(discount != null) {
                    discounts.put(product.getId(), discount);
                }
            }
        }
        return "integrated:product";
    }

}
