package application;

import java.math.BigInteger;
import java.util.Arrays;

public class Programms {

    public static void main(String[] args) {
        try {
            System.out.println(calculateFactorial(10));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(calculateTriangleArea(0, 1));
        } catch (InvalideTriangleException e) {
            System.out.println(e.getMessage());
        }
        try {
            calculateSumSubtractionMultiplicationDivision(0, 1);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

    public static BigInteger calculateFactorial(int n) throws ArithmeticException {
        if (n < 0) {
            throw new ArithmeticException("Нельзя вычислить факториал отрицательного числа");
        }
        if (n == 0) {
            return BigInteger.ONE;
        } else {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                factorial = factorial.multiply((BigInteger.valueOf(i)));
            }
            return factorial;
        }
    }

    public static double calculateTriangleArea(double sideLength, double highLength) throws InvalideTriangleException {
        if (highLength > sideLength || sideLength == 0 || highLength == 0) {
            throw new InvalideTriangleException("Такой треугольник не может существовать");
        }
        if (highLength < 0 || sideLength < 0) {
            throw new InvalideTriangleException("Длины высот и сторон не могут быть отрицательными");
        }
        return 0.5 * sideLength * highLength;
    }

    public static double[] calculateSumSubtractionMultiplicationDivision(int numberOne, int numberTwo) throws ArithmeticException {
        double[] resultOperations = new double[4];
        resultOperations[0] = (double) numberOne + numberTwo;
        resultOperations[1] = (double) numberOne - numberTwo;
        resultOperations[2] = (double) numberOne * numberTwo;
        if (numberTwo == 0) {
            throw new ArithmeticException("Деление на ноль");
        } else {
            resultOperations[3] = (double) numberOne / numberTwo;
        }
        return resultOperations;
    }

    public static void numbersComparison(int numberOne, int numberTwo) {
        if (numberOne > numberTwo) {
            System.out.printf("Число %d больше числа %d.%n", numberOne, numberTwo);
        } else if (numberOne < numberTwo) {
            System.out.printf("Число %d меньше числа %d.%n", numberOne, numberTwo);
        } else {
            System.out.println("Числа равны");
        }
    }


}
