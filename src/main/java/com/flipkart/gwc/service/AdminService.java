package com.flipkart.gwc.service;

import com.flipkart.gwc.dal.*;
import com.flipkart.gwc.model.*;

import java.util.Map;
import java.util.stream.Collectors;

public class AdminService {
    private  static CourseDal courseDal;
    private  static RequestDal requestDal;

    public AdminService(CourseDal courseDal, RequestDal requestDal) {
        this.courseDal = courseDal;
        this.requestDal = requestDal;
    }
    public static Map<Long,Course> getAllCourse() {
        return courseDal.findAll();
    }

    public static Map<Long, Request> getRequestsbyProfessor(Long professorId) {
        // Assuming you have a logic to filter requests by professor
        return requestDal.findAll().entrySet().stream()
                .filter(entry -> entry.getValue().getCourse().getProfessor().getId().equals(professorId))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    public static Map<Long, Request> getRequestsbyStudent(Long professorId) {
        // Assuming you have a logic to filter requests by professor
        return requestDal.findAll().entrySet().stream()
                .filter(entry -> entry.getValue().getCourse().getProfessor().getId().equals(professorId))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    public static Request approveRequest(Long requestId) {
        Request request = requestDal.findById(requestId);
        if (request != null) {
            request.setStatus("APPROVED");
            return requestDal.save(request);
        }
        return null;
    }
    public static Request rejectRequest(Long requestId) {
        Request request = requestDal.findById(requestId);
        if (request != null) {
            request.setStatus("REJECTED");
            return requestDal.save(request);
        }
        return null;
    }
}
