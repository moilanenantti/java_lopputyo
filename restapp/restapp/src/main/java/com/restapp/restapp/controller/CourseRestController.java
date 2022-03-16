package com.restapp.restapp.controller;

import com.restapp.restapp.data.Course;
import com.restapp.restapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseRestController {

    @Autowired
    CourseService myCourseService;

    @GetMapping("courses") //get all courses
    public List<Course> getCourses(){
        return myCourseService.getCourses();
    }

    @GetMapping("courses/{id}") //get course by id
    public Course getCourseById(@PathVariable Integer id) {
        return myCourseService.getCourseById(id);
    }

    @PostMapping("courses") //add a course
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@RequestBody Course course){
        myCourseService.addCourse(course);
        System.out.println("Added new course " + course);
    }

    @DeleteMapping("courses/{id}") //delete course by its ID
    public void deleteCourse(@PathVariable Integer id) { //path variable = course ID
        myCourseService.deleteCourse(id);
    }
}
