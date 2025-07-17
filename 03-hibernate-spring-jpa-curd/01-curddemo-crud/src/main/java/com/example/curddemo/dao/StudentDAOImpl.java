package com.example.curddemo.dao;

import com.example.curddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    //define field for entity manager
    private EntityManager entityManager;

    //injection entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student ReadbyId(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create a query

//        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

           // lastName e fild nu name chhe stude ma jai ne jovu
          TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);




        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void Update(Student student) {
         entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int Id) {
        Student student = entityManager.find(Student.class, Id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    // Additional methods for CRUD operations can be added here
}
