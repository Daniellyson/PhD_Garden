package com.spring.henallux.phD_Garden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale) {
        model.addAttribute("title", "PhD Garden");
        model.addAttribute("locale", locale.getLanguage());
        return "integrated:home";
    }
}