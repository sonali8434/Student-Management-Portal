package com.flipkart.gwc.service;

import com.flipkart.gwc.dal.StudentDal;

public class StudentService {
    private StudentDal studentDal;
    public StudentService(StudentDal studentDal) {
        this.studentDal = studentDal;
    }
}
