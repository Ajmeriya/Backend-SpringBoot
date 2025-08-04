package com.example.spring_rest_curd_project.dao;

import com.example.spring_rest_curd_project.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entityManager
    //set up constructor injection


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntitymanager)
    {
        entityManager=theEntitymanager;
    }


    @Override
    public List<Employee> findAll() {
        //Create a query
        //execute query bad get result list
        //return the result


        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee>employees=theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {

        Employee tempEmployee=entityManager.find(Employee.class,theId);

        return tempEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee tempEmployee=entityManager.merge(theEmployee);

        return tempEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee tempEmployee=entityManager.find(Employee.class,theId);
        entityManager.remove(tempEmployee);
    }
}
