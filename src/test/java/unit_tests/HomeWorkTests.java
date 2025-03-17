package unit_tests;

import application.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertAll;

class HomeWorkTests {

    @ParameterizedTest(name = "Проверка вычисления факториала числа из набора валидных данных {index} для числа {1} равный {0}")
    @MethodSource(value = "dataProviderForFactorial")
    @DisplayName("Тест для проверки расчета факториала числа")
     void testFactorialsPositive(int result, int param) {
        Assertions.assertEquals(BigInteger.valueOf(result), Factorial.calculateFactorial(param),
                String.format("Расчитанный факториал числа %d не соответствует ожиданиям", param));
    }

    @Test
    @DisplayName("Тест учета отсутствия возможности расчета факториала отрицательного числа")
     void testFactorialsNegative() {
        Assertions.assertThrows(ArithmeticException.class, () -> Factorial.calculateFactorial(-1),
                "Нельзя вычислить факториал отрицательного числа");
    }

    @Test
    @DisplayName("Тест для проверки расчета площади треуольника")
    void testTriangle() {
        Triangle triangle = new Triangle(6,5);
        Assertions.assertEquals(15, triangle.calculateArea(6, 5),
                "В расчете площади треугольника присутствует ошибка");
    }

    @ParameterizedTest(name = "Проверка вычисления площади треугольника из набора негативных данных" +
            " {index} для длины стороны {1} и длины высоты {0}")
    @MethodSource(value = "dataProviderForTriangleArea")
    @DisplayName("Тест функции расчета площади треугольника с невалидными параметрами")
    void testTriangleAreaNegativeInoutData(double sideLength, double highLength) {
        Triangle triangle = new Triangle(sideLength, highLength);
        Assertions.assertThrows(InvalideTriangleException.class, () -> triangle.calculateArea(sideLength, highLength),
                "Такой треугольник не существует");
    }

    @ParameterizedTest(name = "Набор данных для проверки математических операций {index}, " +
            "на вход подаются числа {4} и {5}. Сумма: {0}, разность: {1}, произведение {2}, частное: {3} ")
    @MethodSource(value = "dataProviderForCalculationOperations")
    @DisplayName("Тест проверки расчета математических операций суммы, разности, произведения, частного")
    void calculationOperationsTest(double sum, double subtract, double mul, double div, int numberOne, int numberTwo) {
        assertAll(
                () -> Assertions.assertEquals(sum, CalculatorLite.calculateSum(numberOne, numberTwo),
                        "Суммирование проведено некорректно"),
                () -> Assertions.assertEquals(subtract, CalculatorLite.calculateSubtraction(numberOne, numberTwo),
                        "Вычитание проведено некорректно"),
                () -> Assertions.assertEquals(mul, CalculatorLite.calculateMultiplication(numberOne, numberTwo),
                        "Умножение произведено некорректно"),
                () -> Assertions.assertEquals(div, CalculatorLite.calculateDivision(numberOne, numberTwo),
                        "Деление произведено некорректно")
        );
    }

    @Test
    @DisplayName("Тест на запрет деления на ноль")
    void zeroDivisionDeniedTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> CalculatorLite.calculateDivision(1, 0),
                "Попытка деления на ноль");
    }

    @ParameterizedTest()
    @CsvSource({
            "50, 13, 'Число 50 больше числа 13.\n'",
            "0, 0, 'Числа равны.\n'",
            "0, 1, 'Число 0 меньше числа 1.\n'",
            "-20, -30, 'Число -20 больше числа -30.\n'",
            "-5, 10, 'Число -5 меньше числа 10.\n'"
    })
    @DisplayName("Тест на корректное сравнение чисел")
    void searchingGreaterNumberTest(int numberOne, int numberTwo, String result) {
        Assertions.assertEquals(result.trim(), NumberComparator.compareNumbers(numberOne, numberTwo).trim());
    }

    private static Object[][] dataProviderForFactorial() {
        return new Object[][] {
                {1, 1},
                {1, 0},
                {24, 4},
                {3628800, 10}
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
                {1.0, -1.0, 0.0, 0.0, 0, 1},
                {21, 7, 98, 2, 14, 7},
                {-110, 90, 1000, 0.1, -10, -100}
        };
    }


}
