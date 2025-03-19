package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


class SeleniumUsedTests {
    WebDriver driver;
    WebDriverWait wait;
    WebElement onlineReplenishmentWithoutCommissionForm;


    @BeforeAll
    static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpDriverObject() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("http://mts.by");
            onlineReplenishmentWithoutCommissionForm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'pay__wrapper')]")));
        } catch (Exception e) {
            System.out.println("Форма не загрузилась" + e.getMessage());
        }


    }
//    @AfterEach
//    void tearsDown() {
//        driver.quit();
//    }

    @Test
    @DisplayName("Тест на соответствие названия блока «Онлайн пополнение без комиссии»")
    void test1() {
    Assertions.assertEquals("Онлайн пополнение без комиссии",
     onlineReplenishmentWithoutCommissionForm.       );
    }
}
