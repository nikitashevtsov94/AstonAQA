package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class OnlineReplenishmentWithoutCommissionForm extends BasePage {
    private final By formHeader = By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']");
    private final By visaLogo = By.xpath("//img[@alt='Visa']");
    private final By verifiedByVisa = By.xpath("//img[@alt='Verified By Visa']");
    private final By masterCard = By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']");
    private final By masterCardSecureCode = By.xpath("//img[@alt='MasterCard Secure Code']");
    private final By belCard = By.xpath("//div[@class='pay__partners']//img[@alt='Белкарт']");
    private final By serviceDetailsHyperText = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");
    private final By paymentTypeButton = By.className("select__header");
    private final By actualPaymentTypeSelection = By.xpath("//span[@class='select__now']");
    private final By communicationServices = By.xpath("//p[contains(text(),'Услуги связи')]");
    private final By phoneNumberInputFieldCommunicationServices = By.id("connection-phone");
    private final By moneySumInputFieldCommunicationServices = By.id("connection-sum");
    private final By emailInputFieldCommunicationServices = By.id("connection-email");
    private final By continuePayFormButtonCommunicationServices
            = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
    private final By homeInternet = By.xpath("//p[contains(text(),'Домашний интернет')]");
    private final By subscriberPhoneNumberInputFieldHomeInternet = By.id("internet-phone");
    private final By moneySumInputFieldHomeInternet = By.id("internet-sum");
    private final By emailInputFieldHomeInternet = By.id("internet-email");
    private final By installmentPlan = By.xpath("//p[contains(text(),'Рассрочка')]");
    private final By accountNumberInputFieldInstallmentPlan = By.id("score-instalment");
    private final By moneySumInputFieldInstallmentPlan = By.id("instalment-sum");
    private final By emailInputFieldInstallmentPlan = By.id("instalment-email");
    private final By debt = By.xpath("//p[contains(text(),'Задолженность')]");
    private final By accountNumberInputFieldDebt = By.id("score-arrears");
    private final By moneySumInputFieldDebt = By.id("arrears-sum");
    private final By emailInputFieldDebt = By.id("arrears-email");

    private final Logger logger = Logger.getLogger(OnlineReplenishmentWithoutCommissionForm.class.getName());

    private static final String TEST_PHONE_NUMBER = "297777777";

    public OnlineReplenishmentWithoutCommissionForm(WebDriver driver) {
        super(driver);
    }

    public String getOrcFormHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formHeader)).getText().replace("\n", StringUtils.SPACE);
    }

    public List<By> getPaymentsLogo() {
        return Arrays.asList(visaLogo, verifiedByVisa, masterCard, masterCardSecureCode, belCard);
    }

    public void detailsHyperTextClick() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceDetailsHyperText)).click();
    }

    public void typePhoneNumber() {
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInputFieldCommunicationServices)).click();
        driver.findElement(phoneNumberInputFieldCommunicationServices).sendKeys(TEST_PHONE_NUMBER);
    }

    public void typePaymentSum(int sum) {
        wait.until(ExpectedConditions.elementToBeClickable(moneySumInputFieldCommunicationServices)).click();
        driver.findElement(moneySumInputFieldCommunicationServices).sendKeys(String.valueOf(sum));
    }

    public void clickContinueButtonCommunicationServices() {
        wait.until(ExpectedConditions.elementToBeClickable(continuePayFormButtonCommunicationServices)).click();
    }

    public void selectCommunicationServicesPaymentType() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentTypeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(communicationServices)).click();
        logger.info("Вырбран тип оплаты \" Услуги связи\"");
    }

    public void selectHomeInternetPaymentType() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentTypeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(homeInternet)).click();
        logger.info("Вырбран тип оплаты \" Домашний интернет\"");
    }

    public void selectInstallmentPlanPaymentType() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentTypeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(installmentPlan)).click();
        logger.info("Вырбран тип оплаты \" Рассрочка\"");
    }

    public void selectDebtPaymentType() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentTypeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(debt)).click();
        logger.info("Вырбран тип оплаты \" Задолженность\"");
    }

    public void fillAndAcceptCommunicationServicesDataSection(int sum) {
        typePhoneNumber();
        typePaymentSum(sum);
        clickContinueButtonCommunicationServices();
        logger.info("Нажата кнопка продолжить на форме пополнения счета");
    }

    public String getActualPaymentSection() {
        return driver.findElement(actualPaymentTypeSelection).getText();
    }

    public String getPhoneNumberPlaceHolderCommunicationServices() {
        return driver.findElement(phoneNumberInputFieldCommunicationServices).getDomAttribute("placeholder");
    }

    public String getMoneySumInputFieldPlaceHolderCommunicationServices() {
        return driver.findElement(moneySumInputFieldCommunicationServices).getDomAttribute("placeholder");
    }

    public String getEmailInputFieldPlaceHolderCommunicationServices() {
        return driver.findElement(emailInputFieldCommunicationServices).getDomAttribute("placeholder");
    }

    public String getSubscriberPhoneNumberInputFieldPlaceHolderHomeInternet() {
        return driver.findElement(subscriberPhoneNumberInputFieldHomeInternet).getDomAttribute("placeholder");
    }

    public String getMoneySumInputFieldPlaceHolderHomeInternet() {
        return driver.findElement(moneySumInputFieldHomeInternet).getDomAttribute("placeholder");
    }

    public String getEmailInputFieldPlaceHolderHomeInternet() {
        return driver.findElement(emailInputFieldHomeInternet).getDomAttribute("placeholder");
    }

    public String getAccountNumberInputFieldPlaceHolderInstallmentPlan() {
        return driver.findElement(accountNumberInputFieldInstallmentPlan).getDomAttribute("placeholder");
    }

    public String getMoneySumInputFieldPlaceHolderInstallmentPlan() {
        return driver.findElement(moneySumInputFieldInstallmentPlan).getDomAttribute("placeholder");
    }

    public String getEmailInputFieldPlaceHolderInstallmentPlan() {
        return driver.findElement(emailInputFieldInstallmentPlan).getDomAttribute("placeholder");
    }

    public String getAccountNumberInputFieldPlaceHolderDebt() {
        return driver.findElement(accountNumberInputFieldDebt).getDomAttribute("placeholder");
    }

    public String getMoneySumInputFieldPlaceHolderDebt() {
        return driver.findElement(moneySumInputFieldDebt).getDomAttribute("placeholder");
    }

    public String getEmailInputFieldPlaceHolderDebt() {
        return driver.findElement(emailInputFieldDebt).getDomAttribute("placeholder");
    }


}
