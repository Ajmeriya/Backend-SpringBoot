package com.example.spring_rest_curd_project.rest;

import com.example.spring_rest_curd_project.entity.Employee;
import com.example.spring_rest_curd_project.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    // Constructor injection
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper objectMapper) {
        this.employeeService = theEmployeeService;
        this.objectMapper = objectMapper;
    }

    // GET: return all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // GET: return a specific employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }
        return theEmployee;
    }

    // POST: add a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0); // force insert
        return employeeService.save(theEmployee);
    }

    // PUT: update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    // DELETE: delete an employee by ID
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
    }

    // PATCH: partial update of employee
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("You are not allowed to change ID");
        }

        Employee patchedEmployee = applyPatch(patchPayload, tempEmployee);
        return employeeService.save(patchedEmployee);
    }

    // Helper method to apply patch
    private Employee applyPatch(Map<String, Object> patchPayload, Employee tempEmployee)
    {
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
