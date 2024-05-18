package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Marksheet;

import java.util.HashMap;
import java.util.Map;

public class MarksheetDal {
    private Map<Long, Marksheet> marksheets = new HashMap<>();
    private long currentId = 1;

    public Marksheet save(Marksheet marksheet) {
        if (marksheet.getId() == null) {
            marksheet.setId(currentId++);
        }
        marksheets.put(marksheet.getId(), marksheet);
        return marksheet;
    }

    public Marksheet findById(Long id) {
        return marksheets.get(id);
    }

    public void deleteById(Long id) {
        marksheets.remove(id);
    }

    public Map<Long, Marksheet> findAll() {
        return marksheets;
    }
}
