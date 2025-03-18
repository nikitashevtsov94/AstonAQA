package unit_tests;

import application.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;

public class HomeWorkTests {
    @DataProvider
    private static Object[][] dataProviderForFactorial() {
        return new Object[][]{
                {1, 1},
                {1, 0},
                {24, 4},
                {3628800, 10}
        };
    }

    @DataProvider
    private static Object[][] dataProviderForTriangleArea() {
        return new Object[][]{
                {0, 1},
                {1, 0},
                {0, 0},
                {-1, 2},
                {-1, -1}
        };
    }

    @DataProvider
    private static Object[][] dataProviderForCalculationOperations() {
        return new Object[][]{
                {1, -1, 0, 0.0, 0, 1},
                {21, 7, 98, 2.0, 14, 7},
                {-110, 90, 1000, 0.1, -10, -100}
        };
    }

    @Test(dataProvider = "dataProviderForFactorial",
            description = "Тест для проверки расчета факториала числа")
    void testFactorialsPositive(int result, int param) {
        Assert.assertEquals(BigInteger.valueOf(result), Factorial.calculateFactorial(param),
                String.format("Расчитанный факториал числа %d не соответствует ожиданиям", param));
    }

    @Test(description = "Тест учета отсутствия возможности расчета факториала отрицательного числа")
    void testFactorialsNegativeInput() {
        Assert.assertThrows("Нельзя вычислить факториал отрицательного числа", ArithmeticException.class, () -> Factorial.calculateFactorial(-1));
    }

    @Test(description = "Тест для проверки расчета площади треуольника")
    void testTriangleCalculationArea() {
        Triangle triangle = new Triangle(6, 5);
        Assert.assertEquals(triangle.calculateArea(6, 5), 15,
                "В расчете площади треугольника присутствует ошибка");
    }

    @Test(dataProvider = "dataProviderForTriangleArea",
            description = "Тест функции расчета площади треугольника с невалидными параметрами сторон")
    void testTriangleAreaNegativeInputData(double sideLength, double highLength) {
        Triangle triangle = new Triangle(sideLength, highLength);
        Assert.assertThrows("Такой треугольник не существует", InvalideTriangleException.class,
                () -> triangle.calculateArea(sideLength, highLength)
        );
    }

    @Test(dataProvider = "dataProviderForCalculationOperations",
            description = "Тест проверки расчета математических операций суммы, разности, произведения, частного")
    void calculationOperationsTest(int sum, int subtract, int mul, double div, int numberOne, int numberTwo) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sum, CalculatorLite.calculateSum(numberOne, numberTwo),
                "Суммирование проведено некорректно");
        softAssert.assertEquals(subtract, CalculatorLite.calculateSubtraction(numberOne, numberTwo),
                "Вычитание проведено некорректно");
        softAssert.assertEquals(mul, CalculatorLite.calculateMultiplication(numberOne, numberTwo),
                "Умножение произведено некорректно");
        softAssert.assertEquals(div, CalculatorLite.calculateDivision(numberOne, numberTwo),
                "Деление произведено некорректно");
        softAssert.assertAll("Ошибка математической операции");
    }

    @Test(description = "Тест на запрет деления на ноль")
    void zeroDivisionDeniedTest() {
        Assert.assertThrows("Попытка деления на ноль", ArithmeticException.class,
                () -> CalculatorLite.calculateDivision(1, 0)
        );
    }

    @DataProvider
    private static Object[][] csvDataProvider() {
        return new Object[][]{
                {50, 13, "Число 50 больше числа 13.\n"},
                {0, 0, "Числа равны.\n"},
                {0, 1, "Число 0 меньше числа 1.\n"},
                {-20, -30, "Число -20 больше числа -30.\n"},
                {-5, 10, "Число -5 меньше числа 10.\n"}
        };
    }

    @Test(dataProvider = "csvDataProvider",
            description = "Тест на корректное сравнение чисел")
    void searchingGreaterNumberTest(int numberOne, int numberTwo, String result) {
        Assert.assertEquals(NumberComparator.compareNumbers(numberOne, numberTwo).trim(), result.trim());
    }

}

