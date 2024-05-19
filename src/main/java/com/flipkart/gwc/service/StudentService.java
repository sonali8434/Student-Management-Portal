package com.flipkart.gwc.service;

import com.flipkart.gwc.model.Course;
import com.flipkart.gwc.model.Enrollment;
import com.flipkart.gwc.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private Map<Long, Student> students;
    private Map<Long, List<Enrollment>> enrollments;

    public StudentService() {
        this.students = new HashMap<>();
        this.enrollments = new HashMap<>();
    }

    public Student createStudent(Student student) {
        student.setId(System.currentTimeMillis()); // Simple unique ID generation
        students.put(student.getId(), student);
        return student;
    }

    public Student getStudent(Long id) {
        return students.get(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student updateStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public void deleteStudent(Long id) {
        students.remove(id);
    }

    public void enrollStudent(Long studentId, Long courseId) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        enrollments.computeIfAbsent(studentId, k -> new ArrayList<>()).add(enrollment);
    }

    public void withdrawStudent(Long studentId, Long courseId) {
        enrollments.getOrDefault(studentId, new ArrayList<>()).removeIf(e -> e.getCourseId().equals(courseId));
    }

    public List<Course> getEnrolledCourses(Long studentId) {
        List<Course> enrolledCourses = new ArrayList<>();
        for (Enrollment enrollment : enrollments.getOrDefault(studentId, new ArrayList<>())) {
            Course course = new Course(); // You might need to fetch course details from another data structure
            enrolledCourses.add(course);
        }
        return enrolledCourses;
    }
}
