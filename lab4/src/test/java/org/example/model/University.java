package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private final String name; // Назва університету
    private final Human head; // Керівник університету
    private final List<Faculty> faculties; // Список факультетів університету

    // Конструктор для створення університету з назвою, керівником та списком факультетів
    public University(String name, Human head) {
        this.name = name;
        this.head = head;
        this.faculties = new ArrayList<>(); // Ініціалізація списку факультетів
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFaculties() {
        return new ArrayList<>(faculties);
    }

    // Метод для додавання факультету в університет
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public String toString() {
        return "University: " + name +
                "\nHead: " + head +
                "\nFaculties: " + faculties; // Виведення всіх факультетів та керівника університету
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Якщо це той самий об'єкт, то рівні
        if (obj == null || getClass() != obj.getClass()) return false; // Якщо об'єкт порожній або не університет, повертаємо false
        University that = (University) obj;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(faculties, that.faculties); // Порівняння за всіма полями
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, faculties); // Обчислення хеш-коду для університету
    }
}
