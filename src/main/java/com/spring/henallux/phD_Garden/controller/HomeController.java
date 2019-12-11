package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.model.Category;
import com.spring.henallux.phD_Garden.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value="/home")
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String home(@PathVariable("id") Integer id, Model model, Locale locale) {

        List<Category> categories = (List<Category>)categoryService.getAllCategories();

        //TODO return categoryService.loadCategory(id)
        model.addAttribute("currentCategory", categoryService);
        model.addAttribute("categories", categories);
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("title", "PhD Garden");

        return "integrated:home";
    }
}