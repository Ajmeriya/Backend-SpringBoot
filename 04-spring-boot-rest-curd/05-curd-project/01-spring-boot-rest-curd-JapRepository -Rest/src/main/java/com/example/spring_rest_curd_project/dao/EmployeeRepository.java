package com.example.spring_rest_curd_project.dao;

import com.example.spring_rest_curd_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
