package com.klu.controller;

import com.klu.model.Student;
import com.klu.exception.*;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();

    public StudentController(){

        students.add(new Student(1,"Shreyash","CSE"));
        students.add(new Student(2,"Rahul","ECE"));
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){

        if(id<=0){
            throw new InvalidInputException("Student ID must be positive");
        }

        for(Student s:students){
            if(s.getId()==id){
                return s;
            }
        }

        throw new StudentNotFoundException("Student with ID "+id+" not found");
    }
}