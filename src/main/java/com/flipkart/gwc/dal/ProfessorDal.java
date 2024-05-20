package com.flipkart.gwc.dal;

import com.flipkart.gwc.model.Professor;

import java.util.HashMap;
import java.util.Map;

public class ProfessorDal {
    private final Map<Long, Professor> professors = new HashMap<>();
    private long currentId = 1;

    public void save(Professor professor) {
        if (professor.getId() == null) {
            professor.setId(currentId++);
        }
        professors.put(professor.getId(), professor);
    }

    public Professor findById(Long id) {
        return professors.get(id);
    }
    //Add professor
    public void addProfessor(Professor professor) {
        professors.put(professor.getId(), professor);
    }
    //Deleting professor
    public void deleteProfessor(long professorId) {
        professors.remove(professorId);
    }
    public void deleteById(Long id) {
        professors.remove(id);
    }

    public Map<Long, Professor> findAll() {
        return professors;
    }
}
