package my_work_with_collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Task1
        HashSet<Student> students = new HashSet<>();

        Student student1 = new Student("Иван", "A", 2, Arrays.asList(1, 2, 4, 1));
        Student student2 = new Student("Пётр", "B", 3, Arrays.asList(5, 5, 5, 5));
        Student student3 = new Student("Дарья", "C", 3, Arrays.asList(1, 2, 5, 5));
        Student student4 = new Student("Владимир", "D", 2, Arrays.asList(3, 5, 4, 4));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        University.getStudentsInfo(students);
        University.excludeFromUniversity(students);
        University.getStudentsInfo(students);
        University.transitToNextCourse(students);
        University.getStudentsInfo(students);
        University.printStudent(students, 4);

        //Task2
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        Contact contact1 = new Contact("Иванов", "297636161");
        Contact contact2 = new Contact("Петров", "297636060");
        Contact contact3 = new Contact("Сидоров", "333323232");
        Contact contact4 = new Contact("Иванов", "296005020");

        telephoneDirectory.addNewContact(contact1);
        telephoneDirectory.addNewContact(contact2);
        telephoneDirectory.addNewContact(contact3);
        telephoneDirectory.addNewContact(contact4);

        telephoneDirectory.getAllInfoFromTelephoneDirectory();

        telephoneDirectory.getPhoneNumberByLastName("Иванов");
    }
}
