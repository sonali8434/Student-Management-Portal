package com.flipkart.gwc.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private Long id;
    private String name;
    private String description;
    private String department;
    private Professor professor;
    private Set<Student> students;

    public Course() {
        this.students = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setCourseName(String javaProgramming) {
        this.name=name;
    }

    public void setCourseDescription(String s) {
        this.description=description;
    }

    public String getCourseName() {
    return name;
    }
}
