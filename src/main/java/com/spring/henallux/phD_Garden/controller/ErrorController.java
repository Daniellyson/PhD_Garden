package com.spring.henallux.phD_Garden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


@Controller
@RequestMapping(value = "/error")
public class ErrorController extends BaseController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping(method = RequestMethod.GET)
    public String error(HttpServletRequest httpRequest, Model model, Locale locale) {

        int errorCode = (Integer) httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        model.addAttribute("errorCode", errorCode);

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
