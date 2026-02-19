package com.sirrdev.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class Student {
    //used to define the primary key wich is needed to define
    @Id
    @GeneratedValue
    private Integer id;
    @Column(
            name = "c_fname",
            length = 20

    )
    private  String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    @OneToOne(
            //this field student is created in the StudentProfile
            mappedBy = "student",
            //when a student is deleted, his profile is also delete as well
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToOne
    @JoinColumn(name = "school_id")
    //@JsonBackReference in the in the child to fix infinite recursion 4:54
    @JsonBackReference
    private School school;

    //this default constructor with no agrs is needed to transform this java class into an entity
    public Student() {
    }

    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
