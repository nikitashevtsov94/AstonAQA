package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.CookieWindowPage;
import pages.DetailsAboutServicePage;
import pages.IFramePaymentPage;
import pages.OnlineReplenishmentWithoutCommissionForm;
import pages.ScreenshotExtension;
import pages.TestData;

import java.util.logging.Logger;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HomeWork16Test {

    private static WebDriver driver;
    private static BasePage mtsMain;
    private static CookieWindowPage cookieForm;
    private static OnlineReplenishmentWithoutCommissionForm orcForm;
    private static DetailsAboutServicePage dasPage;
    private static IFramePaymentPage iFramePaymentPage;
    @RegisterExtension
    static ScreenshotExtension screenshotExtension = new ScreenshotExtension(() -> driver);;

    private final Logger logger = Logger.getLogger(HomeWork16Test.class.getName());

    @BeforeAll
    static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mtsMain = new BasePage(driver);
        cookieForm = new CookieWindowPage(driver);
        orcForm = new OnlineReplenishmentWithoutCommissionForm(driver);
        dasPage = new DetailsAboutServicePage(driver);
        iFramePaymentPage = new IFramePaymentPage(driver);

    }

    @BeforeEach
    @Step("Подготовка теста: загрузка сайта MTS.BY, принятие Cookies, проверка наличия формы \" Онлайн пополнение\n" +
            "без комиссии\"")
    void setUpDriverObject() {
        mtsMain.loadBaseUrl();
        cookieForm.acceptCookie();
        orcForm.checkPayFormLoaded();
    }

    @AfterAll
    static void tearsDown() {
        mtsMain.closeBrowser();
    }

    @Test
    @Order(1)
    @DisplayName("Тест на соответствие названия блока «Онлайн пополнение без комиссии»")
    @Severity(SeverityLevel.MINOR)
    void OnlineReplenishmentWithoutCommissionHeaderTest() {
        Assertions.assertEquals(TestData.PAYMENT_FORM_HEADER, orcForm.getOrcFormHeader());
    }

    @Test
    @Order(2)
    @DisplayName("Тест наличия логотипов платежных систем")
    @Severity(SeverityLevel.MINOR)
    void logoPaymentSystemPresenceTest() {
        orcForm.getPaymentsLogo().forEach(
                locator -> {
                    Assertions.assertAll(() ->
                            Assertions.assertTrue(orcForm.isLogoPresent(locator),
                                    String.format("Лого %s не появилось", locator)));
                });
    }

    @Test
    @Order(3)
    @DisplayName("Тест на проверку ссылки 'Подробнее о сервисе'")
    @Severity(SeverityLevel.NORMAL)
    void hyperTextTest() {
        orcForm.detailsHyperTextClick();
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", dasPage.getPageHeader());
    }

    @Test
    @Order(4)
    @DisplayName("Тест кнопки 'Продолжить' при пополнении Услуг связи")
    @Severity(SeverityLevel.CRITICAL)
    void buttonContinueTest() {
        Assertions.assertEquals("Услуги связи", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        logger.info("Выбран верный раздел оплаты");
        orcForm.fillAndAcceptCommunicationServicesDataSection(TestData.INPUT_SUM);
        logger.info("Переход на форму заполнения данных о карте");
        iFramePaymentPage.switchToIFrame();
        Assertions.assertTrue(iFramePaymentPage.isCardDataFormAvailable(),
                "Переход на форму заполнения данных о карте не осуществлен");
        logger.info("Форма заполнения данных банковской карты получена");
    }

    @Test()
    @Order(5)
    @DisplayName("Проверка масок ввода для типа оплаты \"Услуги связи\"")
    @Severity(SeverityLevel.MINOR)
    void placeHolderCommunicationServicesTest() {
        orcForm.selectCommunicationServicesPaymentType();
        Assertions.assertEquals("Услуги связи", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер телефона",
                        orcForm.getPhoneNumberPlaceHolderCommunicationServices(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                        orcForm.getMoneySumInputFieldPlaceHolderCommunicationServices(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderCommunicationServices(),
                        "Маска ввода не совпадают с ожидаемым значением")
        );
    }

    @Test()
    @Order(6)
    @DisplayName("Проверка масок ввода для типа оплаты \"Домашний интернет\"")
    @Severity(SeverityLevel.MINOR)
    void placeHolderHomeInternetTest() {
        orcForm.selectHomeInternetPaymentType();
        Assertions.assertEquals("Домашний интернет", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер абонента",
                        orcForm.getSubscriberPhoneNumberInputFieldPlaceHolderHomeInternet(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                        orcForm.getMoneySumInputFieldPlaceHolderHomeInternet(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderHomeInternet(),
                        "Маска ввода не совпадают с ожидаемым значением")
        );
    }

    @Test()
    @Order(7)
    @DisplayName("Проверка масок ввода для типа оплаты \"Рассрочка\"")
    @Severity(SeverityLevel.MINOR)
    void placeHolderInstallmentPlanTest() {
        orcForm.selectInstallmentPlanPaymentType();
        Assertions.assertEquals("Рассрочка", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 44",
                        orcForm.getAccountNumberInputFieldPlaceHolderInstallmentPlan(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                        orcForm.getMoneySumInputFieldPlaceHolderInstallmentPlan(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderInstallmentPlan(),
                        "Маска ввода не совпадают с ожидаемым значением")
        );
    }

    @Test()
    @Order(8)
    @DisplayName("Проверка масок ввода для типа оплаты \"Задолженность\"")
    @Severity(SeverityLevel.MINOR)
    void placeHolderDebtTest() {
        orcForm.selectDebtPaymentType();
        Assertions.assertEquals("Задолженность", orcForm.getActualPaymentSection(),
                "Раздел оплаты не соответствует проверяемому");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 2073",
                        orcForm.getAccountNumberInputFieldPlaceHolderDebt(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Сумма",
                        orcForm.getMoneySumInputFieldPlaceHolderDebt(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("E-mail для отправки чека",
                        orcForm.getEmailInputFieldPlaceHolderDebt(),
                        "Маска ввода не совпадают с ожидаемым значением")
        );
    }

    @Test
    @Order(9)
    @DisplayName("Проверка масок ввода в полях для заполнения данных банковской карты ")
    @Severity(SeverityLevel.MINOR)
    void inputMaskCardFormFieldsTest() {
        iFramePaymentPage.openCardDataPage();
        Assertions.assertTrue(iFramePaymentPage.isCardDataFormAvailable(),
                "Переход на форму заполнения данных о карте не осуществлен");
        logger.info("Форма заполнения данных банковской карты получена");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер карты",
                        iFramePaymentPage.getCardNumberInputFieldPlaceHolder(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Срок действия",
                        iFramePaymentPage.getCardExpirationDateInputFieldPlaceHolder(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("CVC",
                        iFramePaymentPage.getCvcInputFieldPlaceHolder(),
                        "Маска ввода не совпадают с ожидаемым значением"),
                () -> Assertions.assertEquals("Имя держателя (как на карте)",
                        iFramePaymentPage.getCardHolderNameInputFieldPlaceHolder(),
                        "Маска ввода не совпадают с ожидаемым значением")
        );
    }

    @Test
    @Order(10)
    @DisplayName("Тест наличия логотипов платежных систем на форме заполнения данных о карте пользователя")
    @Severity(SeverityLevel.MINOR)
    void logoPaymentSystemsAvailableTest() {
        iFramePaymentPage.openCardDataPage();
        iFramePaymentPage.getPaymentsLogo().forEach(
                locator -> {
                    Assertions.assertAll(() ->
                            Assertions.assertTrue(iFramePaymentPage.isLogoPresent(locator),
                                    String.format("Лого %s не появилось", locator)));
                });
    }

    @Test
    @Order(11)
    @DisplayName("Тест достоверности вводимых значений суммы и номера телефона ")
    @Severity(SeverityLevel.NORMAL)
    void Test() {
        iFramePaymentPage.openCardDataPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals(TestData.TEST_SUM,
                        iFramePaymentPage.getPayDescriptionCostInputMaskText().split(StringUtils.SPACE)[0],
                        "Отображаемая сумма не соответствует ожидаемой"),
                () -> Assertions.assertEquals(TestData.TEST_SUM,
                        iFramePaymentPage.getButtonSubmitPaymentInputMaskText().split(StringUtils.SPACE)[1],
                        "Отображаемая сумма не соответствует ожидаемой"),
                () -> Assertions.assertEquals("375" + TestData.TEST_PHONE_NUMBER,
                        iFramePaymentPage.getPhoneNumberShowHeaderInputMaskText().split(":")[2].trim(),
                        "Отображаемый номер телефона не соответствует ожидаемому")
        );
    }
}
