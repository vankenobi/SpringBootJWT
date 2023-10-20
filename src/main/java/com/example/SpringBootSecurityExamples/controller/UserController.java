package com.example.SpringBootSecurityExamples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
//    private static final List<Student> STUDENTS = Arrays.asList(
//            new Student(1,"musa",24),
//            new Student(2,"melinda",54),
//            new Student(3,"Bill",35),
//            new Student(4,"Adam",55)
//    );

    @GetMapping
    public String hello(){
        return "hello world";
    }

//    @GetMapping("{studentId}")
//    public Student getStudent(@PathVariable("studentId") Integer studentId){
//        return STUDENTS.stream()
//                .filter(a -> studentId.equals(a.getId()))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("Student "+ studentId + " is not there"));
//    }
}
