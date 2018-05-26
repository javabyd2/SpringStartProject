package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.*;

import com.sda.spring.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }



    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> showBoks() {
        return bookService.getBook();
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> showAuthors() {
        return authorService.getAuthor();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> showCategory() {
        return categoryService.getCategory();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> showUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public List<Role> showRoles() {
        return roleService.getRole();
    }

    @RequestMapping(value = "/publisher",method = RequestMethod.GET)
    public List<Publisher> showPublishers(){return publisherService.getPublisher();}


    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/role",method = RequestMethod.POST)
    public Role addRole(@RequestBody Role role){
        return roleService.save(role);
    }

    @RequestMapping (value = "/publisher",method = RequestMethod.POST)
    public Publisher addPublisher(@RequestBody Publisher publisher){
        return publisherService.save(publisher);
    }



    @RequestMapping(value = "/books/{id}",method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.getBookById(id));
    }

    @RequestMapping(value = "/authors/{id}",method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorService.getAuthorById(id));
    }

    @RequestMapping(value = "/category/{id}",method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.getCategoryById(id));
    }

    @RequestMapping(value = "/publisher/{id}",method = RequestMethod.GET)
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(publisherService.getPublisherById(id));
    }






}
