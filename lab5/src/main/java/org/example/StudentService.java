package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentDAO studentDAO = new StudentDAO();

    public List<Student> filterStudentsByMonth(List<Student> students, int month) {
        return students.stream()
                .filter(s -> Integer.parseInt(s.getBirthDate().split("-")[1]) == month)
                .collect(Collectors.toList());
    }
}
