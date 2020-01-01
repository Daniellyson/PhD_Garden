package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.entity.UserEntity;
import com.spring.henallux.phD_Garden.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/authenticated")
public class AuthenticatedController {
    private MessageSource messageSource;

    @Autowired
    public AuthenticatedController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale,
                       Authentication authentication) {
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();
        model.addAttribute("title",  messageSource.getMessage("menu.profile",null,locale));
        model.addAttribute("user", userDetails.toString());
        return "integrated:profil";
    }
}
