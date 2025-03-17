package unit_tests;

import application.InvalideTriangleException;
import application.Programms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertAll;

class HomeWorkTests {

    @ParameterizedTest(name = "Проверка вычисления факториала числа из набора данных {index} для числа {1} равный {0}")
    @MethodSource(value = "dataProviderForFactorial")
    @DisplayName("Тест для проверки расчета факториала числа")
     void testFactorialsPositive(int result, int param) {
        Assertions.assertEquals(BigInteger.valueOf(result), Programms.calculateFactorial(param),
                String.format("Расчитанный факториал числа %d не соответствует ожиданиям", param));
    }

    @Test
    @DisplayName("Тест учета отсутствия возможности расчета факториала отрицательного числа")
     void testFactorialsNegative() {
        Assertions.assertThrows(ArithmeticException.class, () -> Programms.calculateFactorial(-1),
                "Нельзя вычислить факториал отрицательного числа");
    }

    @Test
    @DisplayName("Тест для проверки расчета площади треуольника")
    void testTriangle() {
        Assertions.assertEquals(15, Programms.calculateTriangleArea(6, 5),
                "В расчете площади треугольника присутствует ошибка");
    }

    @Test
    @DisplayName("Тест функции расчета площади треугольника с негативными данными")
    void testTriangleAreaNegativeInoutData() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(InvalideTriangleException.class,
                        () -> Programms.calculateTriangleArea(0, 1), "Такой треугольник не существует"),
                () -> Assertions.assertThrows(InvalideTriangleException.class,
                        () -> Programms.calculateTriangleArea(0, 0), "Такой треугольник не существует"),
                () -> Assertions.assertThrows(InvalideTriangleException.class,
                        () -> Programms.calculateTriangleArea(1, 0), "Такой треугольник не существует"),
                () -> Assertions.assertThrows(InvalideTriangleException.class,
                        () -> Programms.calculateTriangleArea(-1, 2), "Такой треугольник не существует"),
                () -> Assertions.assertThrows(InvalideTriangleException.class,
                        () -> Programms.calculateTriangleArea(-1, -1), "Такой треугольник не существует")
        );

    }

    private static Object[][] dataProviderForFactorial() {
        return new Object[][] {
                {1, 1},
                {1, 0},
                {24, 4},
                {3628800 , 10}
        };
    }


}
