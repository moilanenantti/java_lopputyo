package com.restapp.restapp.service;

import com.restapp.restapp.data.Course;
import com.restapp.restapp.data.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    public List<Course> courses = new ArrayList<>();

    { //Initialize a couple of courses
        Course course1 = new Course("Java for beginners", "Mr. Clever", "Basics of Java");
        Course course2 = new Course("Learn C++", "Mr. BigBrain", "Learn C++ with us");
        Course course3 = new Course("Basics of React", "Mr. Genius", "Exploring React: a JavaScript library");
        Course course4 = new Course("Math 1", "Mr. Smart", "Math class for first year students");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
    }

    public List<Course> getCourses(){ //returns all courses by making a copy of the original list
        return new ArrayList<>(courses);
    }

    public Course getCourseById(Integer id){ //takes course ID as parameter, returns course with matching ID
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public void addCourse(Course course){ //creates a new course by taking course values as parameter
        courses.add(course);
    }

    public void deleteCourse(Integer id) { //takes in course ID as parameter, deletes matching course
        try { //tries to get a course by its ID and then remove it from the course list
            Course course = getCourseById(id);
            courses.remove(course);
            System.out.println("Course with id: " + id + " removed");
        } catch (Exception e) { //if ID's don't match, then print out a message
            System.out.println("Could not find course with id: " + id);
        }
    }
}
