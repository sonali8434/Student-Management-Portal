package com.flipkart.gwc.model;

import java.util.Set;

public class Student {
    private Long id;
    private String name;
    private String email;
<<<<<<< HEAD
    private String department;
    private Set<Course> courses;
=======
>>>>>>> 2d9200435444d8f1f7c2fad5089aa5bc91a67782

    // Getters and setters
    public Long getId() {
        return id;
<<<<<<< HEAD
    }
    public void setId(Long id) {
        this.id = id;
    }
=======
    }

    public void setId(Long id) {
        this.id = id;
    }
>>>>>>> 2d9200435444d8f1f7c2fad5089aa5bc91a67782
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
<<<<<<< HEAD
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
=======
>>>>>>> 2d9200435444d8f1f7c2fad5089aa5bc91a67782
}
