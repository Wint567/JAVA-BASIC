package org.example.controller;

import org.example.model.Human; // Імпорт класу Human
import org.example.model.Student;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String middleName, Human.Sex sex, String studentId) {
        return new Student(firstName, lastName, middleName, sex, studentId);
    }
}
