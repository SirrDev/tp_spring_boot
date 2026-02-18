package com.sirrdev.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//creating a repository for the Student class wich has an id of type Integer
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /*this custom method is created to find a student by his fisrtName
     co's a similar method isn't available in the StudentRepository*/
    List<Student> findAllByFirstNameContaining(String firstName);
}
