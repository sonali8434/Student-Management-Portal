package com.flipkart.gwc.service;

import com.flipkart.gwc.dal.StudentDal;
import com.flipkart.gwc.model.Course;
import com.flipkart.gwc.model.Enrollment;
import com.flipkart.gwc.model.Mark;
import com.flipkart.gwc.model.Student;

import java.util.List;

public class StudentService {
    private final StudentDal studentDal;

    public StudentService(StudentDal studentDal) {
        this.studentDal = studentDal;
    }

    public Student createStudent(Student student) {
        return studentDal.create(student);
    }

    public Student getStudent(Long id) {
        return studentDal.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentDal.findAll();
    }

    public Student updateStudent(Student student) {
        return studentDal.update(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentDal.findById(id);
        if (student != null) {
            studentDal.delete(student);
        }
    }

    public void requestCourseEnrollment(Long studentId, Long courseId) {
        Student student = studentDal.findById(studentId);
        Course course = studentDal.findCourseById(courseId);
        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollment.setStatus("pending");
            studentDal.saveEnrollment(enrollment);
        }
    }

    public void requestCourseDeregistration(Long studentId, Long courseId) {
        Enrollment enrollment = studentDal.findEnrollmentByStudentAndCourse(studentId, courseId);
        if (enrollment != null) {
            studentDal.deleteEnrollment(enrollment);
        }
    }

    public List<Course> viewCourses(Long studentId) {
        return studentDal.findCoursesByStudentId(studentId);
    }

    public List<Course> viewAvailableCourses() {
        return studentDal.findAllCourses();
    }

    public List<Mark> viewMarks(Long studentId) {
        return studentDal.findMarksByStudentId(studentId);
    }
}
