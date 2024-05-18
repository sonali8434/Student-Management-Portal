package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDal {
    private Map<Long, Student> students = new HashMap<>();
    private long currentId = 1;

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(currentId++);
        }
        students.put(student.getId(), student);
        return student;
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
