package com.sda.spring.demo.service;

import com.sda.spring.demo.exceptions.BookNotFoundException;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBook() {
        /*
            dodatkowa logika
         */
        return bookRepository.findAll();
    }


    public Book save(Book book) {
        return bookRepository.save(book);
    }


    public Book getBookById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(
                ()-> new BookNotFoundException(id)
        );
        return book;
    }
}
