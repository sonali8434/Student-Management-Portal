package com.flipkart.gwc.dal;

import java.util.HashMap;
import java.util.Map;

public class StudentDal {
    private Map<String, Integer> studentMarks = new HashMap<String, Integer>();
    public Integer getStudentMarks(String studentId) {
        return studentMarks.get(studentId);
    }
}
