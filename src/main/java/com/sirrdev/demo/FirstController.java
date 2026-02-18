package com.sirrdev.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository repository;

    //constructor injection
    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post (
            @RequestBody Student student
    ) {
        //persisting the student
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent () {
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentId (
            @PathVariable("student-id") Integer  id
    ) {
        return repository.findById(id)
                .orElse(null);
    }
}
