package com.example.spring_rest_curd_project.service;

import com.example.spring_rest_curd_project.dao.EmployeeRepository;
import com.example.spring_rest_curd_project.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeerepository)
    {
        employeeRepository=theEmployeerepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeRepository.findById(theId).orElseThrow(() -> new RuntimeException("Employee not found with id: " + theId));
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
    employeeRepository.deleteById(theId);
    }
}
