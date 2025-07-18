package com.example.demo.rest;


import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/student")
    public List<Student> getStudent()
    {
        List theStudent=new ArrayList<>();

        theStudent.add(new Student("Harsh","Ajmeriya"));
        theStudent.add(new Student("Trith","chapla"));

        return theStudent;
    }


}
