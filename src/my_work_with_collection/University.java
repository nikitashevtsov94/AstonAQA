package my_work_with_collection;

import java.util.Iterator;
import java.util.Set;

public class University {

    private University() {

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
                    System.out.printf("Студент %s отчислен.%n", student.getName());
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

    public static void printStudent(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
