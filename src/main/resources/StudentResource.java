package com.flipkart.gwc.resources;

import com.flipkart.gwc.model.Course;
import com.flipkart.gwc.model.Mark;
import com.flipkart.gwc.model.Student;
import com.flipkart.gwc.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    public Response createStudent(Student student) {
        Student createdStudent = studentService.createStudent(student);
        return Response.ok(createdStudent).build();
    }

    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(student).build();
    }

    @GET
    public Response getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return Response.ok(students).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") Long id, Student student) {
        student.setId(id);
        Student updatedStudent = studentService.updateStudent(student);
        return Response.ok(updatedStudent).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.deleteStudent(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/{id}/enrollments")
    public Response requestCourseEnrollment(@PathParam("id") Long studentId, @QueryParam("courseId") Long courseId) {
        studentService.requestCourseEnrollment(studentId, courseId);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}/enrollments")
    public Response requestCourseDeregistration(@PathParam("id") Long studentId, @QueryParam("courseId") Long courseId) {
        studentService.requestCourseDeregistration(studentId, courseId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}/courses")
    public Response viewCourses(@PathParam("id") Long studentId) {
        List<Course> courses = studentService.viewCourses(studentId);
        return Response.ok(courses).build();
    }

    @GET
    @Path("/available-courses")
    public Response viewAvailableCourses() {
        List<Course> courses = studentService.viewAvailableCourses();
        return Response.ok(courses).build();
    }

    @GET
    @Path("/{id}/marks")
    public Response viewMarks(@PathParam("id") Long studentId) {
        List<Mark> marks = studentService.viewMarks(studentId);
        return Response.ok(marks).build();
    }
}
