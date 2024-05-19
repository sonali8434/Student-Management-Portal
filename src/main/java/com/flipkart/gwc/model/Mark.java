package com.flipkart.gwc.model;

public class Mark {
    private Long id;
    private Student student;
    private Course course;
    private Integer mark;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Integer getMark() {
        return mark;
    }
    public void setMark(Integer mark) {
        this.mark = mark;
    }
}

