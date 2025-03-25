package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.CookieWindowPage;
import pages.DetailsAboutServicePage;
import pages.IFramePaymentPage;
import pages.OnlineReplenishmentWithoutCommissionForm;

import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Logger;

public class HomeWork16Test {

    //    private static final String MTS_URL = "https://www.mts.by/";
//    private static final int WAIT_DURATION = 5;
//    private static final String TEST_PHONE_NUMBER = "297777777";
//    private static final String TEST_SUM = "10";
    private final Logger logger = Logger.getLogger(HomeWork16Test.class.getName());

//    private final By visaLogo = By.xpath("//img[@alt='Visa']");
//    private final By verifiedByVisa = By.xpath("//img[@alt='Verified By Visa']");
//    private final By masterCard = By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']");
//    private final By masterCardSecureCode = By.xpath("//img[@alt='MasterCard Secure Code']");
//    private final By belCard = By.xpath("//div[@class='pay__partners']//img[@alt='Белкарт']");
//    private final By formHeader = By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']");

//    private final By serviceDetailsHyperText = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
//    private final By phoneNumberInputField = By.id("connection-phone");
//    private final By moneySumInputField = By.id("connection-sum");
//    private final By continuePayFormButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
//    private final By iFrame = By.className("bepaid-iframe");
//    private final By creditCardDataForm = By.xpath("//div[contains(@class,'card ng-tns')]");

    private static BasePage mtsMain;
    private static CookieWindowPage cookieForm;
    private static OnlineReplenishmentWithoutCommissionForm orcForm;
    private static DetailsAboutServicePage dasPage;
    private static IFramePaymentPage iFramePaymentPage;

    @BeforeAll
    static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        mtsMain = new BasePage(driver);
        cookieForm = new CookieWindowPage(driver);
        orcForm = new OnlineReplenishmentWithoutCommissionForm(driver);
        dasPage = new DetailsAboutServicePage(driver);
        iFramePaymentPage = new IFramePaymentPage(driver);

    }

    @BeforeEach
    void setUpDriverObject() {
        mtsMain.loadBaseUrl();
        cookieForm.acceptCookie();
        mtsMain.checkPayFormLoaded();


//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
//        driver.manage().window().maximize();
//        driver.get(MTS_URL);
//        acceptCookie();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(payFormWrapper));
    }

    @AfterEach
    void tearsDown() {
        mtsMain.closeBrowser();
    }

    @Test
    @DisplayName("Тест на соответствие названия блока «Онлайн пополнение без комиссии»")
    void OnlineReplenishmentWithoutCommissionHeaderTest() {
        Assertions.assertEquals("Онлайн пополнение без комиссии", orcForm.getOrcFormHeader());
    }

    @Test
    @DisplayName("Тест наличия логотипов платежных систем")
    void logoPaymentSystemPresenceTest() {
        orcForm.getPaymentsLogo().forEach(
                locator -> {
                    Assertions.assertAll(() ->
                            Assertions.assertTrue(orcForm.isLogoPresent(locator), String.format("Лого %s не появилось", locator)));
                });
    }

    @Test
    @DisplayName("Тест на проверку ссылки 'Подробнее о сервисе'")
    void hyperTextTest() {
        orcForm.detailsHyperTextClick();
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", dasPage.getPageHeader());
    }

    @Test
    @DisplayName("Тест кнопки 'Продолжить' при пополнении Услуг связи")
    void buttonContinueTest() {
        Assertions.assertEquals("Услуги связи", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        logger.info("Выбран верный раздел оплаты");
        orcForm.fillCommunicationServicesDataSection(10);
        iFramePaymentPage.switchToIFrame();
        Assertions.assertTrue(iFramePaymentPage.isCardDataFormAvailable(),
                "Переход на форму заполнения данных о карте не осуществлен");
        logger.info("Форма заполнения данных банковской карты получена");
    }

    @Test()
    @DisplayName("Проверка плейсхолдеров для типа оплаты \"Услуги связи\"")
    void placeHolderCommunicationServicesTest() {
        orcForm.selectCommunicationServicesPaymentType();
        Assertions.assertEquals("Услуги связи", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер телефона",
                        orcForm.getPhoneNumberPlaceHolderCommunicationServices(),
                        "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                orcForm.getMoneySumInputFieldPlaceHolderCommunicationServices(),
                "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderCommunicationServices(),
                        "Маски ввода не совпадают с ожидаемым значением")
        );

    }

    @Test()
    @DisplayName("Проверка плейсхолдеров для типа оплаты \"Домашний интернет\"")
    void placeHolderHomeInternetTest() {
        orcForm.selectHomeInternetPaymentType();
        Assertions.assertEquals("Домашний интернет", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер абонента",
                        orcForm.getSubscriberPhoneNumberInputFieldPlaceHolderHomeInternet(),
                        "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                        orcForm.getMoneySumInputFieldPlaceHolderHomeInternet(),
                        "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderHomeInternet(),
                        "Маски ввода не совпадают с ожидаемым значением")
        );
    }

    @Test()
    @DisplayName("Проверка плейсхолдеров для типа оплаты \"Рассрочка\"")
    void placeHolderInstallmentPlanTest() {
        orcForm.selectInstallmentPlanPaymentType();
        Assertions.assertEquals("Рассрочка", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 44",
                        orcForm.getAccountNumberInputFieldPlaceHolderInstallmentPlan(),
                        "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                        orcForm.getMoneySumInputFieldPlaceHolderInstallmentPlan(),
                        "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderInstallmentPlan(),
                        "Маски ввода не совпадают с ожидаемым значением")
        );
    }

    @Test()
    @DisplayName("Проверка плейсхолдеров для типа оплаты \"Задолженность\"")
    void placeHolderDebtTest() {
        orcForm.selectDebtPaymentType();
        Assertions.assertEquals("Задолженность", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 2073",
                        orcForm.getAccountNumberInputFieldPlaceHolderDebt(),
                        "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                        orcForm.getMoneySumInputFieldPlaceHolderDebt(),
                        "Маски ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderDebt(),
                        "Маски ввода не совпадают с ожидаемым значением")
        );
    }

    @Test
    @DisplayName("Тест ")
    void test() {
        orcForm.selectCommunicationServicesPaymentType();
        Assertions.assertEquals("Услуги связи", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        logger.info("Выбран верный раздел оплаты");
        orcForm.fillCommunicationServicesDataSection(10);
        iFramePaymentPage.switchToIFrame();
        logger.info("Переход на форму заполнения данных о карте");
        Assertions.assertTrue(iFramePaymentPage.hasMaestroLogo());
        logger.info("Форма заполнения данных банковской карты получена");
    }
}
