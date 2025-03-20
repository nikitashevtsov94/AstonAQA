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


class SeleniumUsedTests {
    WebDriver driver;
    WebDriverWait wait;
    By payFormWrapper = By.xpath("//div[contains(@class, 'pay__wrapper')]");
    By formHeader = By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']");
    By cookieAgreeButtonLocator = By.xpath("//button[contains(@id,'cookie-agree')]");
    static By visaLogoLocator = By.xpath("//img[@alt='Visa']");
    static By verifiedByVisaLocator = By.xpath("//img[@alt='Verified By Visa']");
    static By masterCardLocator = By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']");
    static By masterCardSecureCodeLocator = By.xpath("//img[@alt='MasterCard Secure Code']");
    static By belcardLocator = By.xpath("//div[@class='pay__partners']//img[@alt='Белкарт']");
    By serviceDetailsHyperText = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
    By securityAndPaymentInfoPageHeader = By.xpath("//meta[contains(@content, " +
            "'Порядок оплаты и безопасность интернет платежей')]");
    By phoneNumberInputField = By.xpath("//input[@id='connection-phone']");
    By moneySumInputField = By.xpath("//input[@id='connection-sum']");
    By continuePayFormButton = By.xpath("//form[@id='pay-connection']//button[@type='submit'][contains(text(),'Продолжить')]");
    By iFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    By creditCardDataForm = By.xpath("//div[@class='card ng-tns-c891095944-0']");

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
            wait.until(ExpectedConditions.elementToBeClickable((cookieAgreeButtonLocator))).click();
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
    @MethodSource(value = "dataProvider")
    @DisplayName("Тест наличия логотипов платежных систем")
    void logoPaymentSystemPresenceTest(By attributeValue) {
        try {
            boolean isLogoPresence = wait.until(ExpectedConditions.visibilityOfElementLocated(attributeValue)) != null;
            Assertions.assertTrue(isLogoPresence, "Лого не появилось");
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
        wait.until(ExpectedConditions.elementToBeClickable(serviceDetailsHyperText)).click();
        String metaContent = driver.findElement(securityAndPaymentInfoPageHeader).getDomAttribute("content");
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", metaContent);
    }

    @Test
    @DisplayName("Тест кнопки 'Continue'")
    void buttonContinueTest() {
        WebElement phoneNumberField = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInputField));
        phoneNumberField.click();
        phoneNumberField.sendKeys("297777777");
        WebElement moneySumField = wait.until(ExpectedConditions.elementToBeClickable(
                moneySumInputField));
        moneySumField.click();
        moneySumField.sendKeys("10");
        wait.until(ExpectedConditions.elementToBeClickable(continuePayFormButton)).click();
        System.out.println("Нажата кнопка продолжить на форме пополнения счета");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        boolean isCardDataForm = wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardDataForm)) != null;
        Assertions.assertTrue(isCardDataForm, "Переход на форму заполнения данных о карте не осуществлен");
        System.out.println("Форма заполнения данных банковской карты получена");
    }
}


