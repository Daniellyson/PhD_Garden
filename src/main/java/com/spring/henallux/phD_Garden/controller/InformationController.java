package com.spring.henallux.phD_Garden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/about-us")
public class InformationController extends BaseController {

    @RequestMapping(method= RequestMethod.GET)
    public String enterpriseInformation(Model model, Locale locale) {
        model.addAttribute("title", getMessageSource().getMessage("information", null, locale));
        return "integrated:information";
    }
}
