package com.sirrdev.demo;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    //convert the student object to get the new final version wich is gonna be returned
    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    //Transforming StudentDto object above into Student object using the following method
    public Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool((school));

        return student;
    }
}
