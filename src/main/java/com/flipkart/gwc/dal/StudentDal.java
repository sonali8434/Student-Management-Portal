package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Student;

<<<<<<< HEAD
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
=======
import java.util.HashMap;
import java.util.Map;

public class StudentDal {
    private Map<Long, Student> students = new HashMap<>();
    private long currentId = 1;

    public void save(Student student) {
        if (student.getId() == null) {
            student.setId(currentId++);
        }
        students.put(student.getId(), student);
    }

    public Student findById(Long id) {
        return students.get(id);
    }

    public void deleteById(Long id) {
        students.remove(id);
    }

    public Map<Long, Student> findAll() {
        return students;
>>>>>>> 2d9200435444d8f1f7c2fad5089aa5bc91a67782
    }
}
