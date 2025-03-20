package org.example.controller;

import org.example.model.Group;
import org.example.model.Human;
import org.example.model.Student;

public class GroupCreator {
    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }

    public void addStudent(Group group, Student student) {
        group.addStudent(student);
    }
}

