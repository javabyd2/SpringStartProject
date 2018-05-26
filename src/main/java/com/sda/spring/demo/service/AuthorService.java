package com.sda.spring.demo.service;

import com.sda.spring.demo.exceptions.AuthorNotFoundException;
import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {


    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthor() {
        /*
            dodatkowa logika
         */
        return authorRepository.findAll();
    }


    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(
                ()->new AuthorNotFoundException(id)
        );
        return author;
    }
}
