package com.flipkart.gwc;

import com.flipkart.gwc.dal.*;
import com.flipkart.gwc.model.Professor;
import com.flipkart.gwc.model.Request;
import com.flipkart.gwc.model.Student;
import com.flipkart.gwc.model.Course;
import com.flipkart.gwc.service.ProfessorService;

public class Main {
    public static void main(String[] args) {
        CourseDal courseDal = new CourseDal();
        RequestDal requestDal = new RequestDal();
        MarksheetDal marksheetDal = new MarksheetDal();
        StudentDal studentDal = new StudentDal();
        ProfessorDal professorDal = new ProfessorDal();

        ProfessorService professorService = new ProfessorService(
                courseDal, requestDal, marksheetDal, studentDal, professorDal);

        // Add a professor
        Professor professor = new Professor();
        professor.setName("XYZ");
        professor.setEmail("XYZ@gmail.com");
        professor.setDepartment("Computer Science");
        professorDal.save(professor);

        // Add a course
        Course course = new Course();
        course.setCourseName("Java Programming");
        course.setCourseDescription("Learn Java.");
        course.setDepartment("Computer Science");
        course.setProfessor(professor);
        professorService.addCourse(course);

        // List all courses
        System.out.println("All courses:");
        professorService.getAllCourses().forEach((id, c) -> System.out.println(c.getCourseName()));


        Student student = new Student();
        student.setName("Student1");
        student.setEmail("studentemail@gmail.com");
        studentDal.save(student);

        // Create a request
        Request request = new Request();
        request.setStudent(student);
        request.setCourse(course);
        request.setStatus("PENDING");
        requestDal.save(request);

        // Approve the request
        professorService.approveRequest(request.getId());

        // Verify the request status
        Request updatedRequest = requestDal.findById(request.getId());
        System.out.println("Request status: " + updatedRequest.getStatus());
    }
}
