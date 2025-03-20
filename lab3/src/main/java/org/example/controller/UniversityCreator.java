package org.example.controller;

import org.example.model.Faculty;
import org.example.model.Human;
import org.example.model.University;

public class UniversityCreator {
    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }

    public void addFaculty(University university, Faculty faculty) {
        university.addFaculty(faculty);
    }
}

