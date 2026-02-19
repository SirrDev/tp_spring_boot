package com.sirrdev.demo;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        //because we have a relationship between Student and School,
        // so we need the schoolId  instead of the whole school object
        Integer schoolId
) {

}
