package com.spring.henallux.phD_Garden.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Controller
public class BaseController {
    @Autowired
    private MessageSource messageSource;
}
