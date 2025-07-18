package com.example.demo.rest;


import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudent;

    @PostConstruct
    public void loadData()
    {
        theStudent=new ArrayList<>();

        theStudent.add(new Student("Harsh","Ajmeriya"));
        theStudent.add(new Student("Trith","chapla"));
        theStudent.add(new Student("Rohit","Ajmeriya"));
        theStudent.add(new Student("Sahil","Ajmeriya"));
        theStudent.add(new Student("Ankit","Ajmeriya"));

    }

    @GetMapping("/student")
    public List<Student> getStudent()
    {
        return theStudent;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if(studentId>=theStudent.size() || studentId<0)
        {
            //aaya object bane chhe aetle constructor call thse ane massgae set thase
            //hve responseEntity<StudentErrorRespons> StudentNotFoundException ne catch karse .
            throw new StudentNotFoundException("Student id not found - " + studentId);

        }
        return theStudent.get(studentId);
    }


    //Add exception handler using @ExceptionHandler
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
