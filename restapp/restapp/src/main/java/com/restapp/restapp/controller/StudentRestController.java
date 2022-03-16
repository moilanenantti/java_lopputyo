package com.restapp.restapp.controller;

import com.restapp.restapp.data.Student;
import com.restapp.restapp.data.Course;
import com.restapp.restapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentService myStudentService;

    @GetMapping("students") //get all students
    public List<Student> getStudents() {
        return myStudentService.getStudents();
    }

    @GetMapping("students/{id}") //get student by id
    public Student getStudentById(@PathVariable Integer id) {
        return myStudentService.getStudentById(id);
    }

    @PostMapping("students") //add student
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        myStudentService.addStudent(student);
        System.out.println("Added new student: " + student);
    }

    @GetMapping("/students/{id}/courses") //get all courses of a student (by student id)
    public List<Course> getStudentCourses(@PathVariable Integer id) { //path variable = student's ID
            return myStudentService.getStudentCourses(id);
    }

    @PostMapping("/students/{studentId}/{courseId}") //add student to a course by using ID's of a student and a course
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudentToCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        myStudentService.addStudentToCourse(studentId, courseId);
    }

    @DeleteMapping("/students/{studentId}/{courseId}") //remove student from a course by giving ID's of the student and the course to be removed
    public void removeStudentFromCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        myStudentService.removeStudentFromCourse(studentId, courseId);
    }

    @DeleteMapping("students/{id}") //delete student by its ID
    public void deleteStudent(@PathVariable Integer id) { //path variable = student's ID
        myStudentService.deleteStudent(id);
    }
}
