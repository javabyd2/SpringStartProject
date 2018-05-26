package com.sda.spring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity handlerException(BookNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND,"Nie znaleziono ksiazki", Arrays.asList("test","test2")));

    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity handlerException(AuthorNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND,"Nie znaleziono autora",Arrays.asList("test")));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity handlerException(CategoryNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND,"Nie znaleziono kategorii",Arrays.asList("test")));
    }

    @ExceptionHandler(PublisherNotFoundException.class)
    public ResponseEntity handlerException(PublisherNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError((HttpStatus.NOT_FOUND),"Nie znaleziono wydawcy",Arrays.asList("test")));
    }

}
