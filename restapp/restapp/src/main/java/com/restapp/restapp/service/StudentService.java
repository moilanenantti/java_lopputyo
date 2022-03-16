package com.restapp.restapp.service;

import com.restapp.restapp.data.Student;
import com.restapp.restapp.data.Course;
import com.restapp.restapp.controller.CourseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    CourseRestController courseController;

    private List<Student> students = new ArrayList<>();
    private List<Course> init1 = new ArrayList<>();
    private List<Course> init2 = new ArrayList<>();

    { //Initializing a couple of students
        //Course course1 = new Course("Java for beginners", "Mr. Clever", "Basics of Java");
        //Course course2 = new Course("Learn C++", "Mr. BigBrain", "Learn C++ with us");
        //Course course3 = new Course("Basics of React", "Mr. Genius", "Exploring React: a JavaScript library");

        //init1.add(course1);
        //init1.add(course2);
        //init2.add(course3);

        Student student1 = new Student("Matthew Mabee", "TVT21KMO",
                "matthew.mabee@unistudent.org", init1);

        Student student2 = new Student("Myles Rice", "TVT21KMO",
                "myles.rice@unistudent.org", init2);

        students.add(student1);
        students.add(student2);
    }

    public List<Student> getStudents(){ //returns all students by making a copy of the original list
        return new ArrayList<>(students);
    }

    public Student getStudentById(Integer id){ //takes student ID as parameter, returns student with matching ID
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student){ //creates a new student by taking student values as parameter
        students.add(student);
    }

    public List<Course> getStudentCourses(Integer id) { //gets all courses of a student by the student's ID
        Student student = getStudentById(id); //gets a student by it's ID
        return student.getCourses(); //gets and returns all courses of the student
    }

    public void addStudentToCourse(Integer studentId, Integer courseId) { //adds student to a course by taking in student and course IDs as parameters
        Student student = getStudentById(studentId); //gets a student by ID
        Course course = courseController.getCourseById(courseId); //gets a course by ID
        //System.out.println("Student: " + student);
        //System.out.println("Course: " + course);
        List<Course> myCourses = student.getCourses(); //creates a course type of list and fills it with the given student's current courses

        if (getStudentById(studentId) == null || courseController.getCourseById(courseId) == null) {
            System.out.println("Could not find student or course with given id's");
        } else {
            myCourses.add(course); //if student and course found, then add given course to the existing list of the student's courses
            student.setCourse(myCourses); //sets modified course list as the student's list of courses
            System.out.println("Student with id: " + studentId + " added to course: " + course);
        }
    }

    public void removeStudentFromCourse(Integer studentId, Integer courseId){ //removes a student from a course by taking in student and course IDs as parameters
        try {
            Student student = getStudentById(studentId); //gets student by its id
            Course course = courseController.getCourseById(courseId); //gets course by its ID
            List<Course> myCourses = student.getCourses(); //creates a list copy of the student's current courses
            myCourses.remove(course); //removes the given course from the current course list copy
            student.setCourse(myCourses); //sets the modified list as the student's list of courses
            System.out.println("Student with id: " + studentId + " removed from course: " + course);
        } catch (Exception e) { //if student or course not found by ID
            System.out.println("Could not find student with id: " + studentId + " or course with id: " + courseId);
        }
    }

    public void deleteStudent(Integer id) { //takes in student ID as parameter, deletes matching student
        try { //tries to get a student by its ID and then remove it from the student list
            Student student = getStudentById(id);
            students.remove(student);
            System.out.println("Student with id: " + id + " removed");
        } catch (Exception e) { //if ID's don't match, then print out a message
            System.out.println("Could not find student with id: " + id);
        }
    }
}
