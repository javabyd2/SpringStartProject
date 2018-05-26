package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/web/authors")
    public ModelAndView autor(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("authorsList",authorService.getAuthor());
        modelAndView.setViewName("authors");
        return modelAndView;
    }

    @GetMapping(value = "/web/users")
    public ModelAndView users(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList",userService.getUsers());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @GetMapping (value = "/web/books")
    public ModelAndView books(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksList",bookService.getBook());
        modelAndView.setViewName("books");
        return modelAndView;
    }




}
