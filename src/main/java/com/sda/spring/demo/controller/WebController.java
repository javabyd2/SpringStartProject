package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Role;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.RoleService;
import com.sda.spring.demo.service.UserService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/web/authors")
    public ModelAndView autor() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("authorsList", authorService.getAuthor());
        modelAndView.setViewName("authors");
        return modelAndView;
    }

    @GetMapping(value = "/web/users")
    public ModelAndView users() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList", userService.getUsers());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @GetMapping(value = "/web/books")
    public ModelAndView books() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksList", bookService.getBook());
        modelAndView.setViewName("books");
        return modelAndView;
    }

    @PostMapping(value = "/web/addrole")
    public String addRole(@ModelAttribute("role") Role role, RedirectAttributes redirectAttributes) {
        roleService.save(role);
        redirectAttributes.addFlashAttribute("message", "Dodano pomyślnie");
        return "redirect:/web/roleform";
    }

    @GetMapping(value = "/web/roleform")
    public ModelAndView roleForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("roleform");
        modelAndView.addObject("role", new Role());
        return modelAndView;
    }

    @GetMapping(value = "/web/roles")
    public ModelAndView roles() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rolesList", roleService.getRole());
        modelAndView.setViewName("role");
        return modelAndView;
    }
}
