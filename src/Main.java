package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Set<Student> secondStudents = new HashSet<>();

        Student student1 = new Student("Иван", "A", 2, Arrays.asList());
        Student student2 = new Student("Пётр", "B", 4, Arrays.asList(5, 5, 5, 5));
        Student student3 = new Student("Дарья", "C", 3, Arrays.asList(1, 2, 5, 5));
        Student student4 = new Student("Владимир", "D", 2, Arrays.asList(3, 5, 4, 4));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        secondStudents.add(student1);
        secondStudents.add(student2);
        secondStudents.add(student3);
        secondStudents.add(student4);

//        getStudentsInfo(students);
//        excludeFromUniversity(students);
//        getStudentsInfo(students);
//        transitToNextCourse(students);
//        getStudentsInfo(students);
        printStudent(secondStudents, 2);


    }

    public static void getStudentsInfo(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void excludeFromUniversity(List<Student> students) {
        for (int j = students.size() - 1; j >= 0; j--) {
            Student student = students.get(j);
            try {
                double average = calculateAverageGrade(student);
                if (average < 3) {
                    students.remove(student);
                }
            } catch (MyArithmeticException e) {
                System.out.printf("У студента %s отсутствуют оценки.%n", student.getName());
            }
        }
    }

    public static void transitToNextCourse(List<Student> students) {
        for (Student student : students) {
            try {
                double average = calculateAverageGrade(student);
                if (average >= 3) {
                    student.setCourse(student.getCourse() + 1);
                    System.out.printf("Студент %s переведен на следующий курс.%n", student.getName());
                }
            } catch (MyArithmeticException e) {
                System.out.printf("У студента %s отсутствуют оценки.%n", student.getName());
            }
        }
    }

    private static double calculateAverageGrade(Student student) throws MyArithmeticException {
        int size = student.getGrades().size();
        if (size == 0) {
            throw new MyArithmeticException(String.format("У студента %s отсутствуют оценки.%n", student.getName()));
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
