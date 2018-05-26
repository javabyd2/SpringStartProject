package com.sda.spring.demo.repository;

import com.sda.spring.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Author findByName(String name);

    public Author findByLastName(String lastName);




}
