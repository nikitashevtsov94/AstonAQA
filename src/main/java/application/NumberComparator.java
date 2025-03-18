package application;

public class NumberComparator {
    public static String compareNumbers(int numberOne, int numberTwo) {
        if (numberOne > numberTwo) {
            return String.format("Число %d больше числа %d.%n", numberOne, numberTwo);
        } else if (numberOne < numberTwo) {
            return String.format("Число %d меньше числа %d.%n", numberOne, numberTwo);
        } else {
            return "Числа равны.\n";
        }
    }
}
