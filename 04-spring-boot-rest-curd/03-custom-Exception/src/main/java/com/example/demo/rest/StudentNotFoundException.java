package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message)
    {
        super(message);
        System.out.println("StudentNotFoundException: " + message);
    }

//    public StudentNotFoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public StudentNotFoundException(Throwable cause) {
//        super(cause);
//    }



}
