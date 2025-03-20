package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name; // Назва факультету
    private Human head; // Керівник факультету
    private List<Department> departments; // Список відділів на факультеті

    // Конструктор для створення факультету з назвою та керівником
    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
        this.departments = new ArrayList<>(); // Ініціалізація списку відділів
    }

    // Метод для додавання відділу на факультет
    public void addDepartment(Department department) {
        departments.add(department);
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    // Метод для виведення інформації про факультет
    @Override
    public String toString() {
        return "Faculty: " + name + ", Head: " + head + ", Departments: " + departments;
    }

    // Перевизначення методу equals для порівняння двох об'єктів типу Faculty
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Якщо це той самий об'єкт, то рівні
        if (!(o instanceof Faculty)) return false; // Якщо об'єкт не є факультетом, повертаємо false
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Objects.equals(head, faculty.head) && Objects.equals(departments, faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments); // Обчислення хеш-коду для факультету
    }
}
