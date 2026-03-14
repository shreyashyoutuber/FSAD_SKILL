package com.klu.controller;

import com.klu.model.Course;
import com.klu.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course){

        service.addCourse(course);
        return new ResponseEntity<>("Course added successfully",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){

        return new ResponseEntity<>(service.getAllCourses(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,@RequestBody Course course){

        Course updated = service.updateCourse(id,course);

        if(updated!=null)
            return new ResponseEntity<>("Course updated",HttpStatus.OK);

        return new ResponseEntity<>("Course not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){

        boolean deleted = service.deleteCourse(id);

        if(deleted)
            return new ResponseEntity<>("Course deleted",HttpStatus.OK);

        return new ResponseEntity<>("Course not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title){

        List<Course> list = service.searchByTitle(title);

        if(list.isEmpty())
            return new ResponseEntity<>("No course found",HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}