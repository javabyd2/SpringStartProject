package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//        Set<Author> authors = new HashSet<>();
//        authors.add(new Author("Herman", "Melville"));
//        authors.add(new Author("Boleslaw", "Prus"));
//
//
//        Category LF = new Category("Literary Fiction");
//        Category NOV = new Category("Novel");
//
//        Book book1 = new Book("Moby Dick", LF, authors);
//        Book book2 = new Book("Lalka", NOV, authors);
//
//
//        bookRepository.save(book1);


    }
}
