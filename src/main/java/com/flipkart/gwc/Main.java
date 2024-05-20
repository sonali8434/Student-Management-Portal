package com.flipkart.gwc;

import com.flipkart.gwc.dal.*;
import com.flipkart.gwc.model.Professor;
import com.flipkart.gwc.model.Request;
import com.flipkart.gwc.model.Student;
import com.flipkart.gwc.model.Course;
import com.flipkart.gwc.service.AdminService;
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
        //Adding Student
        Student std = new Student();
        std.setName("Student1");
        std.setEmail("studentemail@gmail.com");
        studentDal.addStudent(std);
        // Delete a student
        studentDal.deleteStudent(std.getId());
        // Adding a professor
        Professor professors = new Professor();
        professors.setName("XYZ");
        professors.setEmail("XYZ@gmail.com");
        professors.setDepartment("Computer Science");
        professorDal.addProfessor(professors);
        // Delete a professor
        professorDal.deleteProfessor(professors.getId());


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
        //Update a course
        Course updatedCourse = new Course();
        updatedCourse.setId(course.getId());
        courseDal.updateCourse(updatedCourse);

        // Delete a course
        courseDal.deleteCourse(course.getId());


        // Create a request
        Request request = new Request();
        request.setStudent(student);
        request.setCourse(course);
        request.setStatus("PENDING");
        requestDal.save(request);
        // Approve the request
        professorService.approveRequest(request.getId());
        //Approve professor request to teach
        AdminService.approveRequest(request.getId());
        //Reject professor request to teach
        AdminService.rejectRequest(request.getId());
        // Verify the request status
        Request updatedRequest = requestDal.findById(request.getId());
        System.out.println("Request status: " + updatedRequest.getStatus());
        request.setId((long)1);
        request.setStatus("PENDING");
        request.setStudent(student);
        //view request by professor
        AdminService.getRequestsbyProfessor(request.getId());
        //View request to join courde by student
        AdminService.getRequestsbyStudent(request.getId());
        //get all course
        AdminService.getAllCourse();
    }
}
