package com.spring.henallux.phD_Garden.controller;

import com.spring.henallux.phD_Garden.dataAccess.util.Constants;
import com.spring.henallux.phD_Garden.model.Form.RegisterForm;
import com.spring.henallux.phD_Garden.model.User;
import com.spring.henallux.phD_Garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/register")
public class RegisterUserController extends BaseController {
    private UserService userService;
    private MessageSource messageSource;

    @Autowired
    public RegisterUserController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource=messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale,
                       @ModelAttribute(Constants.USER_REGISTERING_DETAILS) RegisterForm userRegister,
                       BindingResult errors) {


        model.addAttribute("title",  messageSource.getMessage("menu.register",null,locale));
        return "integrated:register";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(Constants.USER_REGISTERING_DETAILS) RegisterForm userRegister,
                              BindingResult errors) {

        model.addAttribute("categories", categories());

        if (!userRegister.getPassword().equals(userRegister.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "invalid.register.differentPassword");
        }

        if (this.userService.existsByUsername(userRegister.getUsername())) {
            errors.rejectValue("username", "invalid.register.usernameTaken");
        }

        if (!userRegister.getEmail().matches("\\w+@\\w+\\.\\w+")) {
            errors.rejectValue("email", "invalid.register.emailMatche");
        }

        if (userRegister.getBirthdate().after(new Date())) {
            errors.rejectValue("birthdate", "invalid.register.birthdate");
        }

        if (errors.hasErrors()) {
            return "integrated:register";
        }

        User newUser = new User();
        newUser.setUsername(userRegister.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(userRegister.getPassword()));
        newUser.setEmail(userRegister.getEmail());
        newUser.setFirstname(userRegister.getFirstname());
        newUser.setLastname(userRegister.getLastname());
        newUser.setStreet(userRegister.getStreet());
        newUser.setHouse_number(userRegister.getHouse_number());
        newUser.setLocality(userRegister.getLocality());
        newUser.setPostalCode(userRegister.getPostalCode());
        newUser.setPhone(userRegister.getPhone());
        newUser.setGender(userRegister.getGender());
        //newUser.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
        newUser.setAuthorities("ROLE_USER");
        newUser.setAccountNonExpired(true);
        newUser.setAccountNonLocked(true);
        newUser.setCredentialsNonExpired(true);
        newUser.setEnabled(true);

        userService.save(newUser);

        return "redirect:/";
    }
}
