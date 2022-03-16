package com.restapp.restapp.data;

import java.util.List;

public class Student {
    private static int count = 0;

    private int id;
    private String name;
    private String group;
    private String email;
    private List<Course> courses;

    public Student(String name, String group, String email , List<Course> courses){
        this.name = name;
        this.group = group;
        this.email = email;
        this.courses = courses;

        this.id = count++;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses(){
        return this.courses;
    }

    public void setCourse(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() { //returns student values as a string. Used when printing out console log during some operations
        return String.format(
                "[id: %s, name: %s, group: %s, email: %s, courses: %s]", id, name, group, email, courses);
    }
}
