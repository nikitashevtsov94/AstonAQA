package application;

public class CalculatorLite {
    public static int calculateSum(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    public static int calculateSubtraction(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    public static int calculateMultiplication(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    public static double calculateDivision(int numberOne, int numberTwo) throws ArithmeticException {
        if (numberTwo == 0) {
            throw new ArithmeticException("Деление на ноль");
        } else {
            return (double) numberOne / numberTwo;
        }
    }
}
