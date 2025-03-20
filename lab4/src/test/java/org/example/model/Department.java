package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name; // Назва відділу
    private Human head; // Керівник відділу (клас Human)
    private List<Group> groups; // Список груп, що належать до цього відділу

    // Конструктор для створення відділу з назвою та керівником
    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.groups = new ArrayList<>(); // Ініціалізація списку груп
    }

    // Метод для додавання групи в список
    public void addGroup(Group group) {
        groups.add(group);
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Group> getGroups() {
        return groups;
    }

    // Метод для виведення інформації про відділ
    @Override
    public String toString() {
        return "Department: " + name + ", Head: " + head + ", Groups: " + groups;
    }

    // Перевизначення методу equals для порівняння двох об'єктів типу Department
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Якщо це той самий об'єкт, то рівні
        if (!(o instanceof Department)) return false; // Якщо об'єкт не є відділом, повертаємо false
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(head, that.head) && Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups); // Обчислення хеш-коду для відділу
    }
}
