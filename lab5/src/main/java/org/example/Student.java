package org.example;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String studentId;

    public Student(int id, String lastName, String firstName, String middleName, String birthDate, String studentId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.studentId = studentId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s %s, Дата народження: %s, Номер залікової: %s",
                id, lastName, firstName, middleName, birthDate, studentId);
    }
}
