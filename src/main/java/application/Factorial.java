package application;

import java.math.BigInteger;

public class Factorial {
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
}
