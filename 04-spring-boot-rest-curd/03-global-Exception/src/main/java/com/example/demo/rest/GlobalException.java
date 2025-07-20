package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    // This class can be used to handle global exceptions for the application.
    // You can define methods here to handle specific exceptions and return custom responses.

    // Example:
    // @ExceptionHandler(StudentNotFoundException.class)
    // public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
    //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    // }


    @ExceptionHandler
    public ResponseEntity<StudentErrorRespons> handleException(StudentNotFoundException exc)
    {
        //create a studentErrorResponse
        StudentErrorRespons error = new StudentErrorRespons();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity


        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorRespons> handleException(Exception exc)
    {
        //create a studentErrorResponse
        StudentErrorRespons error = new StudentErrorRespons();

        error.setMessage("StudentId maygi ne loda tu string nakhs pachhi kye error aayvi aave j ne ghelchoyda");
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }

}
