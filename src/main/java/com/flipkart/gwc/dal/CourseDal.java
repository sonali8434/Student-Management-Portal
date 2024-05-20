package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Course;

import java.util.HashMap;
import java.util.Map;

public class CourseDal {
    private Map<Long, Course> courses = new HashMap<>();
    private long currentId = 1;

    public Course save(Course course) {
        if (course.getId() == null) {
            course.setId(currentId++);
        }
        courses.put(course.getId(), course);
        return course;
    }
    public void deleteCourse(long id) {
        courses.remove(id);
    }


    public void updateCourse(Course course) {
        courses.put(course.getId(), course);
    }

    public Course findById(Long id) {
        return courses.get(id);
    }

    public void deleteById(Long id) {
        courses.remove(id);
    }

    public Map<Long, Course> findAll() {
        return courses;
    }
}
