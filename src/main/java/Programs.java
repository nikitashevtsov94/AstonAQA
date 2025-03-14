public class Programs {

    public static void main(String[] args) {
        System.out.println(calculateFactorial(3));
        System.out.println(calculateTriangleArea(5.00, 6.00));
    }

    public static int calculateFactorial(int n) {
        int factorial = n;
        for (int i = 1; i < n; i++) {
            factorial = factorial * (n - i);
        }
        return factorial;
    }

    public static double calculateTriangleArea (double sideLength, double highLength) {
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
