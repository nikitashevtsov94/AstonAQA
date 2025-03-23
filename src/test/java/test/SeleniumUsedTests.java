package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Logger;


class SeleniumUsedTests {

    private static final String MTS_URL = "https://www.mts.by/";
    private static final int WAIT_DURATION = 5;
    private static final String TEST_PHONE_NUMBER = "297777777";
    private static final String TEST_SUM = "10";
    private final Logger logger = Logger.getLogger(SeleniumUsedTests.class.getName());

    private final By visaLogo = By.xpath("//img[@alt='Visa']");
    private final By verifiedByVisa = By.xpath("//img[@alt='Verified By Visa']");
    private final By masterCard = By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']");
    private final By masterCardSecureCode = By.xpath("//img[@alt='MasterCard Secure Code']");
    private final By belCard = By.xpath("//div[@class='pay__partners']//img[@alt='Белкарт']");
    private final By payFormWrapper = By.className("pay__wrapper");
    private final By formHeader = By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']");
    private final By cookieForm = By.className("cookie__wrapper");
    private final By cookieAgreeButton = By.id("cookie-agree");
    private final By serviceDetailsHyperText = By.partialLinkText("poryadok-oplaty-i-bezopasnost-internet-platezhey");
    private final By securityAndPaymentInfoPageHeader = By.xpath("//title[normalize-space(.)='Порядок оплаты и безопасность интернет платежей']");
    private final By phoneNumberInputField = By.id("connection-phone");
    private final By moneySumInputField = By.id("connection-sum");
    private final By continuePayFormButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
    private final By iFrame = By.className("bepaid-iframe");
    private final By creditCardDataForm = By.xpath("//div[contains(@class,'card ng-tns')]");

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpDriverObject() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
        driver.manage().window().maximize();
        driver.get(MTS_URL);
        if (isCookiePresent()) {
            wait.until(ExpectedConditions.elementToBeClickable((cookieAgreeButton))).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(payFormWrapper));
    }

    private boolean isCookiePresent() {
        return !driver.findElements(cookieForm).isEmpty();
    }

    @AfterEach
    void tearsDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Тест на соответствие названия блока «Онлайн пополнение без комиссии»")
    void OnlineReplenishmentWithoutCommissionHeaderTest() {
        WebElement header = driver.findElement(formHeader);
        Assertions.assertEquals("Онлайн пополнение без комиссии", header.getText().replace("\n", StringUtils.SPACE));
    }

    @Test
    @DisplayName("Тест наличия логотипов платежных систем")
    void logoPaymentSystemPresenceTest() {
        Arrays.asList(visaLogo, verifiedByVisa, masterCard,
                masterCardSecureCode, belCard).forEach(
                locator -> {
                    boolean isLogoPresence = isLogoPresent(locator);
                    Assertions.assertAll(() ->
                            Assertions.assertTrue(isLogoPresence, String.format("Лого %s не появилось", locator)));
                });
    }

    private boolean isLogoPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
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
        phoneNumberField.sendKeys(TEST_PHONE_NUMBER);
        WebElement moneySumField = wait.until(ExpectedConditions.elementToBeClickable(
                moneySumInputField));
        moneySumField.click();
        moneySumField.sendKeys(TEST_SUM);
        wait.until(ExpectedConditions.elementToBeClickable(continuePayFormButton)).click();
        logger.info("Нажата кнопка продолжить на форме пополнения счета");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        boolean isCardDataForm = wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardDataForm)) != null;
        Assertions.assertTrue(isCardDataForm, "Переход на форму заполнения данных о карте не осуществлен");
        logger.info("Форма заполнения данных банковской карты получена");
    }
}
