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
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


class SeleniumUsedTests {
    WebDriver driver;
    WebDriverWait wait;
    By payFormWrapper = By.xpath("//div[contains(@class, 'pay__wrapper')]");
    By formHeader = By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']");
    By cookieAgreeButtonLocator = By.xpath("//button[contains(@id,'cookie-agree')]");
    static By visaLogoLocator = By.xpath("//img[@alt='Visa']");
    static By verifiedByVisaLocator = By.xpath("//img[@alt='Verified By Visa']");
    static By masterCardLocator = By.xpath("//img[@alt='MasterCard'and@xpath='1']");
    static By masterCardSecureCodeLocator = By.xpath("//img[@alt='MasterCard Secure Code']");
    static By belcardLocator = By.xpath("//img[@alt='Белкарт'and@xpath='1']");
    //a[contains(text(),'Подробнее о сервисе')]
    @BeforeAll
    static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpDriverObject() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        try {
            WebElement cookieAgreeButton = wait.until(ExpectedConditions.elementToBeClickable((cookieAgreeButtonLocator)));
            cookieAgreeButton.click();
        } catch (TimeoutException e) {
            System.out.println("Форма Cookie не появилась" + e.getMessage());
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(payFormWrapper));
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

    @ParameterizedTest
    @MethodSource(value = "dataProvider" )
    @DisplayName("Тест наличия логотипов платежных систем")
    void logoPaymentSystemPresenceTest(By attributeValue) {
        try {
            boolean presence = wait.until(ExpectedConditions.visibilityOfElementLocated(attributeValue)) != null;
            Assertions.assertTrue(presence, "Лого не появилось");
        } catch (TimeoutException e) {
            System.out.println("Отсутствует лого платежной системы: " + attributeValue);
        }

    }

    static List<By> dataProvider() {
        return Arrays.asList(visaLogoLocator, verifiedByVisaLocator, masterCardLocator,
                masterCardSecureCodeLocator, belcardLocator);
    }

    @Test
    @DisplayName("Тест на проверку ссылки 'Подробнее о сервисе'")
    void hyperTextTest() {
        WebElement hyperText = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Подробнее о сервисе')]")));
        hyperText.click();
        System.out.println(driver.getTitle());
        WebElement header = driver.findElement(By.xpath("//meta[contains(@content, " +
                "'Порядок оплаты и безопасность интернет платежей')]"));
        String metaContent = header.getAttribute("content");
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", metaContent);
    }

}
