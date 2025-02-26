import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork9 {

    public static void main(String[] args) {
        //Task1
        printThreeWords();
        System.out.println();

        //Task2
        checkSumSign();
        System.out.println();

        //Task3
        printColor();
        System.out.println();

        //Task4
        compareNumbers ();
        System.out.println();

        //Task5
        System.out.println(rangeOfNumbers(5,12));
        System.out.println();

        //Task6
        checkNumberSign(-3);
        System.out.println();

        //Task7
        System.out.println(isNumberPositive(8));
        System.out.println();

        //Task8
        printStingsSpecifiedNumberOfTimes("Строка", 5);
        System.out.println();

        //Task9
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год, чтобы узнать является ли он високосным");
        int year = scanner.nextInt();
        System.out.println(isLeapYear(year));
        System.out.println();

        //Task10
        int[] array1 = {0, 1, 0, 1, 1, 0, 0, 1, 0, 1};
        System.out.println(Arrays.toString(array1));
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0){
                array1[i] = 1;
            }else {
                array1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array1));
        System.out.println();


        //Task11
        int[] array2 = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        System.out.println(Arrays.toString(array2));
        System.out.println();


        //Task12
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array3));
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6){
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array3));
        System.out.println();


        //Task13
        int[][] sqArray  = new int[7][7];
        for (int i = 0; i < sqArray.length; i++) {
            for (int j = i; j < sqArray[i].length ; j++) {
                sqArray[i][j] = 1;
                sqArray[i][sqArray[i].length - 1 - j] = 1;
                break;
            }
            System.out.println(Arrays.toString(sqArray[i]));
            System.out.println();
        }


        //Task14
        System.out.println(Arrays.toString(setArray(10, 88)));

    }

    //Task 1
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //Task2
    public static void checkSumSign() {
        int a = 4;
        int b = 12;
        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //Task3
    public static void printColor(){
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    //Task4
    public static void compareNumbers (){
        int a = 24;
        int b = 24;
        if (a >= b){
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }

    //Task5
        public static boolean rangeOfNumbers(int a, int b){
        int sum = a + b;
        if (sum >= 10 && sum <= 20){
            return true;
        }else {
            return false;
        }
    }

    //Task6
    public static void checkNumberSign(int a){
        if (a < 0){
            System.out.println("Число отрицательное");
        }else {
            System.out.println("Число положительное");
        }
    }

    //Task7
    public static boolean isNumberPositive(int a) {
        if (a < 0) {
            return false;
        } else {
            return true;
        }
    }

    //Task8
    public static void printStingsSpecifiedNumberOfTimes(String line, int a){
        for (int i = 0; i < a; i++) {
            System.out.println(line);
        }
    }

    //Task9
    public static boolean isLeapYear(int year){
        if (year % 400 == 0){
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }else return false;
    }

    //Task14
    public static int[] setArray(int len, int initialValue){
        int[] array4 = new int[len];
        Arrays.fill(array4, initialValue);
        return array4;
    }

}

