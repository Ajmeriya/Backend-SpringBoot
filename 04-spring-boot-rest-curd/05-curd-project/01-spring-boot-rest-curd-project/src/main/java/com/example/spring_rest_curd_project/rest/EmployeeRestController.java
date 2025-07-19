package com.example.spring_rest_curd_project.rest;

import com.example.spring_rest_curd_project.dao.EmployeeDAO;
import com.example.spring_rest_curd_project.dao.EmployeeDAOJpaImpl;
import com.example.spring_rest_curd_project.entity.Employee;
import com.example.spring_rest_curd_project.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    //quick and dirty : injection employee dao
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper objectMapper)
    {
        employeeService=theEmployeeService;
        objectMapper=this.objectMapper;
    }

    //expose "/employee" and retun a list employee

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee=employeeService.findById(employeeId);

        if(theEmployee==null)
        {
            throw new RuntimeException("Employee Id not found -" + employeeId);
        }
        else
        {
            return theEmployee;
        }
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);

        Employee tempEmployee= employeeService.save(theEmployee);

        return tempEmployee;
    }

    @PutMapping("/employees")
    public Employee uodateEmployee(@RequestBody Employee theEmployee)
    {
        Employee tempEmployee=employeeService.save(theEmployee);

        return tempEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void delateEmployee(@PathVariable("employeeId") int theId)
    {
        employeeService.deleteById(theId);
    }


}
