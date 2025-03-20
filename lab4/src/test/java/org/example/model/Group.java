package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private String name; // Назва групи
    private Human head; // Керівник групи
    private List<Student> students; // Список студентів у групі

    // Конструктор для створення групи з назвою та керівником
    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>(); // Ініціалізація списку студентів
    }

    // Метод для додавання студента до групи
    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Метод для виведення інформації про групу
    @Override
    public String toString() {
        return "Group: " + name + ", Head: " + head + ", Students: " + students;
    }

    // Переозначення методу equals для порівняння двох об'єктів типу Group
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Якщо це той самий об'єкт, то рівні
        if (!(o instanceof Group)) return false; // Якщо об'єкт не є групою, повертаємо false
        Group group = (Group) o;
        return Objects.equals(name, group.name) && Objects.equals(head, group.head) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, students); // Обчислення хеш-коду для групи
    }
}
