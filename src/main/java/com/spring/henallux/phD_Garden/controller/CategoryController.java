package com.spring.henallux.phD_Garden.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

    private CategoryService categoryService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public String category(@PathVariable("id") Integer id, Model model, Locale locale) {

        List<Category> categories = (List<Category>)categoryService.getAllCategories();

        model.addAttribute("title", getMessageSource().getMessage("titleCategory", null, locale));
        model.addAttribute("locale", locale.getLanguage());


        return "integrated:category";
    }

}
