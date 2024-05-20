package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Course;
import com.flipkart.gwc.model.Enrollment;
import com.flipkart.gwc.model.Mark;
import com.flipkart.gwc.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDal {
    private Connection connection;

    // Constructor to initialize database connection
    public StudentDal(Connection connection) {
        this.connection = connection;
    }

    // Method to create a new student
    public Student create(Student student) throws SQLException {
        String query = "INSERT INTO students (name, email, department) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDepartment());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    student.setId(generatedKeys.getLong(1));
                }
            }
        }
        return student;
    }

    // Method to retrieve a student by ID
    public Student findById(Long id) throws SQLException {
        String query = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractStudentFromResultSet(resultSet);
            }
        }
        return null;
    }

    // Method to retrieve all students
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(extractStudentFromResultSet(resultSet));
            }
        }
        return students;
    }

    // Helper method to extract student from ResultSet
    private Student extractStudentFromResultSet(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setDepartment(resultSet.getString("department"));
        return student;
    }

}
