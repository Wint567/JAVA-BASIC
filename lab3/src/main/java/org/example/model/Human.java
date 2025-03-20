package org.example.model;

public abstract class Human {
    private String firstName;
    private String lastName;
    private String middleName;
    private Sex sex;

    public Human(String firstName, String lastName, String middleName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " (" + sex + ")";
    }

    // Вкладений enum для статі
    public enum Sex {
        MALE,
        FEMALE
    }
}
