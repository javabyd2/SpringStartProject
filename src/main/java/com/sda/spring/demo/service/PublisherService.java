package com.sda.spring.demo.service;

import com.sda.spring.demo.exceptions.AuthorNotFoundException;
import com.sda.spring.demo.exceptions.PublisherNotFoundException;
import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Publisher;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {


    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getPublisher() {
        /*
            dodatkowa logika
         */
        return publisherRepository.findAll();
    }


    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(
                ()->new PublisherNotFoundException(id)
        );
        return publisher;
    }
}
