package com.sirrdev.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//creating a repository for the Student class wich has an id of type Integer
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
