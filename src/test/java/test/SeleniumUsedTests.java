package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


class SeleniumUsedTests {
    WebDriver driver;
    WebDriverWait wait;
    By payFormWrapper = By.xpath("//div[contains(@class, 'pay__wrapper')]");
    By formHeader = By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']");
    By cookieAgreeButtonLocator = By.xpath("//button[contains(@id,'cookie-agree')]");
    By visaLogoLocator = By.xpath("//img[@alt='Visa']");
    By verifiedByVisaLocator = By.xpath("//img[@alt='Verified By Visa']");
    By masterCardLocator = By.xpath("//img[@alt='MasterCard'and@xpath='1']");
    By masterCardSecureCodeLocator = By.xpath("//img[@alt='MasterCard Secure Code']");
    By BelcardLocator= By.xpath("//img[@alt='Белкарт'and@xpath='1']");
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
            WebElement cookieAgreeButton = driver.findElement(cookieAgreeButtonLocator);
            cookieAgreeButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(payFormWrapper));

        } catch (NoSuchElementException e) {
            System.out.println("Форма Cookie не появилась" + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Страница не загрузилась" + e.getMessage());
        }


    }

    @AfterEach
    void tearsDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Тест на соответствие названия блока «Онлайн пополнение без комиссии»")
    void OnlineReplenishmentWithoutCommissionHeaderTest() {
        WebElement header = driver.findElement(formHeader);
        Assertions.assertEquals("Онлайн пополнение без комиссии", header.getText().replace("\n", " "));
    }


    @Test
    void logoPaymentSystemPresenceTest() {
        driver.findElement(visaLogoLocator);
        Assertions.assertDoesNotThrow(() -> driver.findElement(visaLogoLocator));
    }
//    @ParameterizedTest
//    @MethodSource(value = "dataProvider")
//    @DisplayName("Тест наличия логотипов платежных систем")
//    void logoPaymentSystemPresenceTest(String attributeValue) {
//
//    }
//
//    static Object[][] dataProvider() {
//        return new Object[][] {
//                {}
//        }
//    }

}
