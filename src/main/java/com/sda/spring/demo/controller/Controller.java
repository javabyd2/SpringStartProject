package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

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

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @RequestMapping(value = "/books/{id}",method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/authors/{id}",method = RequestMethod.GET)
    public Optional<Author> getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @RequestMapping(value = "/category/{id}",method = RequestMethod.GET)
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
