package com.restapp.restapp.data;

public class Course {

    private static int count = 0;
    
    private int id;
    private String name;
    private String teacher;
    private String description;

    public Course(String name, String teacher, String description){
        this.name = name;
        this.teacher = teacher;
        this.description = description;

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() { //returns course values as a string. Used when printing out console log during some operations
        return String.format(
                "[id: %s, name: %s, teacher: %s, description: %s]", id, name,
                teacher, description);
    }
}
