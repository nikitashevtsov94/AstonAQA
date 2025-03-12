package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("Иван", "A", 2, Arrays.asList(1, 2, 5, 1));
        Student student2 = new Student("Пётр", "B", 4, Arrays.asList(5, 5, 5, 5));
        Student student3 = new Student("Дарья", "C", 3, Arrays.asList(1, 2, 5, 5));

        students.add(student1);
        students.add(student2);
        students.add(student3);

        getStudentsInfo(students);
        excludeFromUniversity(students);
        getStudentsInfo(students);



    }

    public static void getStudentsInfo(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void excludeFromUniversity(List<Student> students) {
        for (int j = students.size() - 1; j >= 0 ; j--) {
            Student student = students.get(j);
            int size = student.getGrades().size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum = sum + student.getGrades().get(i);
            }
            if ((double)(sum / size) < 3) {
                students.remove(student);
            }
        }



    }
}
