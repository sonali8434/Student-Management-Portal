package com.flipkart.gwc.service;

import com.flipkart.gwc.dal.*;
import com.flipkart.gwc.model.Course;
import com.flipkart.gwc.model.Request;
import com.flipkart.gwc.model.Student;

import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

public class ProfessorService {
    private final CourseDal courseDal;
    private final RequestDal requestDal;
    private final MarksheetDal marksheetDal;
    private final StudentDal studentDal;
    private final ProfessorDal professorDal;

    public ProfessorService(CourseDal courseDal, RequestDal requestDal, MarksheetDal marksheetDal, StudentDal studentDal, ProfessorDal professorDal) {
        this.courseDal = courseDal;
        this.requestDal = requestDal;
        this.marksheetDal = marksheetDal;
        this.studentDal = studentDal;
        this.professorDal = professorDal;
    }

    public Map<Long, Course> getAllCourses() {
        return courseDal.findAll();
    }

    public Course addCourse(Course course) {
        return courseDal.save(course);
    }

    public void deleteCourse(Long courseId) {
        courseDal.deleteById(courseId);
    }

    public Course updateCourse(Long courseId, Course course) {
        if (courseDal.findById(courseId) != null) {
            course.setId(courseId);
            return courseDal.save(course);
        }
        return null;
    }

    public Map<Long, Request> getRequestsByProfessor(Long professorId) {
        // Assuming you have a logic to filter requests by professor
        return requestDal.findAll().entrySet().stream()
                .filter(entry -> entry.getValue().getCourse().getProfessor().getId().equals(professorId))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Request approveRequest(Long requestId) {
        Request request = requestDal.findById(requestId);
        if (request != null) {
            request.setStatus("APPROVED");
            return requestDal.save(request);
        }
        return null;
    }

    public Request rejectRequest(Long requestId) {
        Request request = requestDal.findById(requestId);
        if (request != null) {
            request.setStatus("REJECTED");
            return requestDal.save(request);
        }
        return null;
    }

    public void addStudentToCourse(Long studentId, Long courseId) throws SQLException {
        Course course = courseDal.findById(courseId);
        Student student = studentDal.findById(studentId);

        if (course != null && student != null) {
            course.getStudents().add(student);
            courseDal.save(course);
        }
    }

    public void removeStudentFromCourse(Long studentId, Long courseId) throws SQLException {
        Course course = courseDal.findById(courseId);
        Student student = studentDal.findById(studentId);

        if (course != null && student != null) {
            course.getStudents().remove(student);
            courseDal.save(course);
        }
    }
}
