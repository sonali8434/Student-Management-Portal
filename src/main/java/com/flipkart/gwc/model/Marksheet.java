package com.flipkart.gwc.model;

import java.util.Map;

public class Marksheet {
    private Long id;
    private Course course;
    private Map<Student, Integer> studentMarks;

    // Getters and setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public Course getCourse() { 
        return course; 
    }
    public void setCourse(Course course) { 
        this.course = course; 
    }
    public Map<Student, Integer> getStudentMarks() { 
        return studentMarks; 
    }
    public void setStudentMarks(Map<Student, Integer> studentMarks) { 
        this.studentMarks = studentMarks; 
    }
}
