package application;

import java.math.BigInteger;

public class Programms {
    import java.math.BigInteger;

    public class Programs {

        public static void main(String[] args) {
            try {
                System.out.println(calculateFactorial(-2));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(calculateTriangleArea(5.00, 6.00));
            } catch (InvalideTriangleException e) {
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

        public static double calculateTriangleArea (double sideLength, double highLength) throws InvalideTriangleException {
            if (highLength > sideLength) {
                throw new InvalideTriangleException("Такой треугольник не может существовать");
            }
            return 0.5 * sideLength * highLength;
        }

        public static void calculateSumSubtractionMultiplicationDivision (int numberOne, int numberTwo) {
            System.out.printf("Сумма чисел: %d.%nРазность чисел: %d.%nПроизведение чисел: %d.%nЧастное из чисел: %d.%n",
                    numberOne + numberTwo, numberOne - numberTwo, numberOne * numberTwo, numberOne + numberTwo);
        }

        public static void numbersComparison (int numberOne, int numberTwo) {
            if (numberOne > numberTwo) {
                System.out.printf("Число %d больше числа %d.%n", numberOne,  numberTwo);
            } else if (numberOne < numberTwo) {
                System.out.printf("Число %d меньше числа %d.%n", numberOne,  numberTwo);
            } else {
                System.out.println("Числа равны");
            }
        }
    }

}
