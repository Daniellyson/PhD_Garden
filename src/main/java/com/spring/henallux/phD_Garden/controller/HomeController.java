package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/home")
public class HomeController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale) {

        model.addAttribute("categories", categories());
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("title", "PhD Garden");

        return "integrated:home";
    }
}