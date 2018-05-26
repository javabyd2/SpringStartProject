package com.sda.spring.demo.exceptions;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException(Long id){
        super("Nie moge znalesc Publisher "+id);
    }
}
