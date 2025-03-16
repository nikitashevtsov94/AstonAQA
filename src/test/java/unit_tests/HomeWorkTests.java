package unit_tests;

import application.Programms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;

public class HomeWorkTests {

    @ParameterizedTest(name = "Проверка вычисления факториала числа {index} {0}")
    @MethodSource(value = "dataProvider")
    @DisplayName("Тест для проверки расчета факториала числа")
    public void testFactorials(int result, int param) {
        Assertions.assertEquals(BigInteger.valueOf(result), Programms.calculateFactorial(param),
                String.format("Расчитанный факториал числа %d не соответствует ожиданиям", param));
    }

    @Test
    @DisplayName("Тест для проверки расчета факториала числа")
    public void testFactorials2() {
        Assertions.assertThrows(ArithmeticException.class, () -> Programms.calculateFactorial(-1), "блабла");
    }

    private static Object[][] dataProvider() {
        return new Object[][] {
                {1, 1},
                {1, 0},
                {3, 4}
        };
    }
}
