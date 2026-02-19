package com.sirrdev.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    //constructor injection
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public StudentResponseDto post (
            //for the dto setting
            @RequestBody StudentDto dto
    ) {
        var student = toStudent(dto);
       var savedStudent = repository.save(student);
       //the return itself : the object being converted
       return toStudentResponseDto(savedStudent);
    }

    //convert the student object to get the new final version wich is gonna be returned
    private StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    //Transforming StudentDto object above into Student object using the following method
    private Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool((school));

        return student;
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
