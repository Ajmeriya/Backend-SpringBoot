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

}
