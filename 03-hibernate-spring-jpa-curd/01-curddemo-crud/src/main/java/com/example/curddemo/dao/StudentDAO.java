package com.example.curddemo.dao;

import com.example.curddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student ReadbyId(int id);
    List<Student> findAll();
    void Update(Student student);
    void delete(int Id);
}
