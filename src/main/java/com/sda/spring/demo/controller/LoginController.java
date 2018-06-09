package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.User;
import com.sda.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView register(User user,
                                 BindingResult bindingResult
    ){
        ModelAndView modelAndView = new ModelAndView();
        User userExist = userService.findByEmail(user.getEmail());

        if(userExist != null){
            bindingResult.rejectValue("email", "error.user","Email jest zajety");
        }

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("registration");
        }else{
            userService.userSave(user);
            modelAndView.addObject("sucessMessage","Witaj w serwisie");
        }
        modelAndView.setViewName("registration");
        return modelAndView;
    }

}
