package com.sirrdev.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    //constructor injection: crucial for dependencies injection
    public StudentController(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/students")
    public StudentResponseDto post (
            //for the dto setting
            @RequestBody StudentDto dto
    ) {
        var student = studentMapper.toStudent(dto);
       var savedStudent = repository.save(student);
       //the return itself : the object being converted
       return studentMapper.toStudentResponseDto(savedStudent);
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

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName (
            @PathVariable("student-name") String  name
    ) {
        return repository.findAllByFirstNameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        repository.deleteById(id);
    }
}
