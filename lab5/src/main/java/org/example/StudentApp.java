package org.example;

import java.util.List;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        StudentProcessor processor = new StudentProcessor();
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть номер місяця (1-12): ");
        int targetMonth = input.nextInt();

        System.out.println("\n1. Завантажити всіх студентів і відфільтрувати в Java");
        System.out.println("2. Виконати SQL-запит для отримання студентів");
        System.out.print("Виберіть варіант (1 або 2): ");
        int option = input.nextInt();

        List<Student> studentList = (option == 1)
                ? processor.filterByBirthMonth(repository.fetchAll(), targetMonth)
                : repository.findByBirthMonth(targetMonth);

        if (studentList.isEmpty()) {
            System.out.println("Немає студентів, народжених у цьому місяці.");
        } else {
            System.out.println("Список студентів:");
            for (int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
                System.out.printf("%d: %s, Дата народження: %s, Номер залікової: %s\n", 
                        i + 1, student.getFullName(), student.getBirthDate(), student.getRecordBookNumber());
            }
        }
    }
}
