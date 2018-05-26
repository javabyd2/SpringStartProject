package com.sda.spring.demo.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException (Long id){
        super("Nie moge znalesc kategorii "+id);
    }
}
