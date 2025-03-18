package unit_tests;

import application.Factorial;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;

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
    @Test(dataProvider = "dataProviderForFactorial")
    public void testFactorialsPositive(int result, int param) {
        assertEquals(BigInteger.valueOf(result), Factorial.calculateFactorial(param),
                String.format("Расчитанный факториал числа %d не соответствует ожиданиям", param));
        }

    }

