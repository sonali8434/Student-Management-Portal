package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Request;

import java.util.HashMap;
import java.util.Map;

public class RequestDal {
    private Map<Long, Request> requests = new HashMap<>();
    Map<Integer, Request> req = new HashMap<>();
    private long currentId = 1;

    public Request save(Request request) {
        if (request.getId() == null) {
            request.setId(currentId++);
        }
        requests.put(request.getId(), request);
        return request;
    }
   public Request sav(Request request){
        requests.put(request.getId(), request);
        return request;
   }
    public Request findById(Long id) {
        return requests.get(id);
    }

    public void deleteById(Long id) {
        requests.remove(id);
    }

    public Map<Long, Request> findAll() {
        return requests;
    }
}
