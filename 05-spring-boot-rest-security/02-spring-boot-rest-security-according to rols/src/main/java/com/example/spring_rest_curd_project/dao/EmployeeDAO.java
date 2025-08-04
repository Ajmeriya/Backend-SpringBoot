package com.example.spring_rest_curd_project.dao;

import com.example.spring_rest_curd_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
