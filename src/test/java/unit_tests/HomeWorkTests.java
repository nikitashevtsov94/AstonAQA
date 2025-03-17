package unit_tests;

import application.InvalideTriangleException;
import application.Programms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
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

    @ParameterizedTest(name = "Проверка вычисления площади треугольника из набора негативных данных" +
            " {index} для длины стороны {1} и длины высоты {0}")
    @MethodSource(value = "dataProviderForTriangleArea")
    @DisplayName("Тест функции расчета площади треугольника с негативными данными")
    void testTriangleAreaNegativeInoutData(double sideLength, double highLength) {
        Assertions.assertThrows(InvalideTriangleException.class, () -> Programms.calculateTriangleArea(sideLength, highLength),
                "Такой треугольник не существует");
    }

    @ParameterizedTest(name = "Набор данных для проверки математических операций теста {index}, " +
            "на вход подаются числа {4} и {5}. Сумма: {0}, разность: {1}, произведение {2}, частное: {3} ")
    @MethodSource(value = "dataProviderForCalculationOperations")
    @DisplayName("Тест проверки расчета математических операций суммы, разности, произведения, частного")
    void calculationOperationsTest(double sum, double subtract, double mul, double div, int numberOne, int numberTwo) {
        Assertions.assertDoesNotThrow(() -> Programms.calculateSumSubtractionMultiplicationDivision(numberOne, numberTwo));
        double[] resultOperation = Programms.calculateSumSubtractionMultiplicationDivision(numberOne, numberTwo);
        assertAll(
                () -> Assertions.assertEquals(sum, resultOperation[0]),
                () -> Assertions.assertEquals(subtract, resultOperation[1]),
                () -> Assertions.assertEquals(mul, resultOperation[2]),
                () -> Assertions.assertEquals(div, resultOperation[3])
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
    private static Object[][] dataProviderForTriangleArea() {
        return new Object[][] {
                {0, 1},
                {1, 0},
                {0, 0},
                {-1, 2},
                {-1, -1}
        };
    }
    private static Object[][] dataProviderForCalculationOperations() {
        return new Object[][] {
                {1.0, -1.0, 0.0, 0.0, 0, 1}
        };
    }


}
