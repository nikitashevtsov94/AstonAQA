package myWorkWithCollection;

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

        getStudentsInfo(students);
        excludeFromUniversity(students);
        getStudentsInfo(students);
        transitToNextCourse(students);
        getStudentsInfo(students);
        printStudent(students, 4);

        //Task2
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        Contact contact1 = new Contact("Иванов", 297636161);
        Contact contact2 = new Contact("Петров", 297636060);
        Contact contact3 = new Contact("Сидоров", 333323232);
        Contact contact4 = new Contact("Иванов", 296005020);

        telephoneDirectory.addNewContact(contact1);
        telephoneDirectory.addNewContact(contact2);
        telephoneDirectory.addNewContact(contact3);
        telephoneDirectory.addNewContact(contact4);

        telephoneDirectory.getAllInfoFromTelephoneDirectory();

        telephoneDirectory.searchName("Иванов");

    }

    public static void getStudentsInfo(Set<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void excludeFromUniversity(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            try {
                double average = calculateAverageGrade(student);
                if (average < 3) {
                    iterator.remove();
                }
            } catch (MyArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void transitToNextCourse(Set<Student> students) {
        for (Student student : students) {
            try {
                double average = calculateAverageGrade(student);
                if (average >= 3) {
                    student.setCourse(student.getCourse() + 1);
                    System.out.printf("Студент %s переведен на следующий курс.%n", student.getName());
                }
            } catch (MyArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double calculateAverageGrade(Student student) throws MyArithmeticException {
        int size = student.getGrades().size();
        if (size == 0) {
            throw new MyArithmeticException("У студента " + student.getName() + " отсутствуют оценки.");
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + student.getGrades().get(i);
        }
        return (double) sum / size;
    }

    private static void printStudent(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
