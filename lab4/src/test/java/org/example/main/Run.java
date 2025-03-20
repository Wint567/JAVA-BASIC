package org.example.main;

import org.example.controller.*;
import org.example.model.*;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        // Ініціалізація університету
        Human rector = new Human("Петро", "Коваленко", "Олександрович", Human.Sex.MALE) {};
        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createUniversity("Національний технічний університет", rector);

        // Створення першого факультету
        Human facultyHead1 = new Human("Ганна", "Михайленко", "Василівна", Human.Sex.FEMALE) {};
        FacultyCreator facultyCreator = new FacultyCreator();
        Faculty faculty1 = facultyCreator.createFaculty("Факультет інформаційних технологій", facultyHead1);

        // Додавання кафедр до факультету
        Human departmentHead1 = new Human("Юрій", "Бойко", "Андрійович", Human.Sex.MALE) {};
        DepartmentCreator departmentCreator = new DepartmentCreator();
        Department department1 = departmentCreator.createDepartment("Кафедра комп'ютерних наук", departmentHead1);

        Human departmentHead2 = new Human("Марина", "Савченко", "Олексіївна", Human.Sex.FEMALE) {};
        Department department2 = departmentCreator.createDepartment("Кафедра інформаційної безпеки", departmentHead2);

        facultyCreator.addDepartment(faculty1, department1);
        facultyCreator.addDepartment(faculty1, department2);

        // Додавання академічних груп до кафедр
        Human groupHead1 = new Human("Володимир", "Терещенко", "Миколайович", Human.Sex.MALE) {};
        GroupCreator groupCreator = new GroupCreator();
        Group group1 = groupCreator.createGroup("Група КН-201", groupHead1);

        Human groupHead2 = new Human("Оксана", "Романенко", "Віталіївна", Human.Sex.FEMALE) {};
        Group group2 = groupCreator.createGroup("Група КН-202", groupHead2);

        departmentCreator.addGroup(department1, group1);
        departmentCreator.addGroup(department1, group2);

        // Додавання студентів до академічних груп
        StudentCreator studentCreator = new StudentCreator();
        Student student1 = studentCreator.createStudent("Максим", "Гончар", "Сергійович", Human.Sex.MALE, "KN201001");
        Student student2 = studentCreator.createStudent("Ірина", "Лисенко", "Валеріївна", Human.Sex.FEMALE, "KN201002");
        Student student3 = studentCreator.createStudent("Денис", "Федоренко", "Ігорович", Human.Sex.MALE, "KN202001");
        Student student4 = studentCreator.createStudent("Аліна", "Шевченко", "Євгенівна", Human.Sex.FEMALE, "KN202002");

        groupCreator.addStudent(group1, student1);
        groupCreator.addStudent(group1, student2);
        groupCreator.addStudent(group2, student3);
        groupCreator.addStudent(group2, student4);

        // Додавання факультету до університету
        universityCreator.addFaculty(university, faculty1);

        // Створення другого факультету
        Human facultyHead2 = new Human("Олег", "Сидоренко", "Михайлович", Human.Sex.MALE) {};
        Faculty faculty2 = facultyCreator.createFaculty("Факультет прикладної математики", facultyHead2);

        universityCreator.addFaculty(university, faculty2);

        // Виведення інформації про університет
        System.out.println(university);
    }
}
