package org.example.test;

import org.example.json.JsonManager;
import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityTest {

    // Тестування серіалізації і десеріалізації об'єкта University в/з JSON формату
    @Test
    public void testJsonSerialization() throws IOException {
        // Створення університету з назвою "Test University" та студентом "John Doe"
        University oldUniversity = new University("Test University", new Student("John", "Doe", "Michael", Human.Sex.MALE, "S101"));

        // Створення факультету "Faculty of Science" та студента "Alice Smith"
        Faculty faculty = new Faculty("Faculty of Science", new Student("Alice", "Smith", "Jane", Human.Sex.FEMALE, "S102"));

        // Створення кафедри "Computer Science" та студента "Bob Brown"
        Department department = new Department("Computer Science", new Student("Bob", "Brown", "James", Human.Sex.MALE, "S103"));

        // Створення групи "CS-101" та студента "Eve Adams"
        Group group = new Group("CS-101", new Student("Eve", "Adams", "Marie", Human.Sex.FEMALE, "S104"));

        // Додавання студентів до групи
        group.addStudent(new Student("Charlie", "Johnson", "David", Human.Sex.MALE, "S105"));
        group.addStudent(new Student("Diana", "White", "Elizabeth", Human.Sex.FEMALE, "S106"));

        // Додавання групи до кафедри, кафедри до факультету та факультету до університету
        department.addGroup(group);
        faculty.addDepartment(department);
        oldUniversity.addFaculty(faculty);

        // Збереження об'єкта oldUniversity у файл "university.json" у JSON форматі
        JsonManager.saveToFile(oldUniversity, "university.json");

        // Завантаження університету з JSON файлу в об'єкт newUniversity
        University newUniversity = JsonManager.loadFromFile("university.json");

        // Перевірка чи рівні об'єкти oldUniversity і newUniversity
        System.out.println("Are universities equal? " + oldUniversity.equals(newUniversity));

        // Використовуємо JUnit assertEquals для порівняння об'єктів
        // Якщо об'єкти однакові, тест пройде успішно
        assertEquals(oldUniversity, newUniversity);
    }
}
