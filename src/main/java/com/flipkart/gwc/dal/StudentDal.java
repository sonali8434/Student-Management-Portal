package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Student;

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
    //Add Student
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }
    //Delete Student
    public void deleteStudent(long studentId) {
        students.remove(studentId);
    }
    public Student findById(Long id) {
        return students.get(id);
    }

    public void deleteById(Long id) {
        students.remove(id);
    }

    public Map<Long, Student> findAll() {
        return students;
    }
}
