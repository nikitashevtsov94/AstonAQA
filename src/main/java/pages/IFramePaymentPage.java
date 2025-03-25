package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class IFramePaymentPage extends BasePage {

    private final Logger logger = Logger.getLogger(IFramePaymentPage.class.getName());

    private final By iFrame = By.className("bepaid-iframe");
    private final By creditCardDataForm = By.xpath("//div[contains(@class,'card ng-tns')]");
    private final By payDescriptionCost = By.xpath("//span[normalize-space()='10.00 BYN']");
    private final By buttonSubmitPayment = By.xpath("//button[contains(text(), 'Оплатить')]");
    private final By cardNumberFieldMask = By.xpath("//label[contains(text(), 'Номер карты')]");
    private final By cardExpirationDateFieldMask = By.xpath("//label[contains(text(), 'Срок действия')]");
    private final By cvcFieldMask = By.xpath("//label[contains(text(), 'CVC')]");
    private final By cardHolderNameFieldMask = By.xpath("//label[contains(text(), 'Имя держателя')]");
    private final By phoneNumberShowHeader = By.xpath("//span[contains(text(),'Оплата')]");
    private final By visaLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']");
    private final By masterCardLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    private final By belCardLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    private final By maestroLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");
    private final By mirLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']");

    private final OnlineReplenishmentWithoutCommissionForm orcForm = new OnlineReplenishmentWithoutCommissionForm(driver);

    public IFramePaymentPage(WebDriver driver) {
        super(driver);
    }

    public void switchToIFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
    }

    public boolean isCardDataFormAvailable() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardDataForm)) != null;
    }

    public String getCardNumberInputFieldPlaceHolder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberFieldMask)).getText();
    }

    public String getCardExpirationDateInputFieldPlaceHolder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpirationDateFieldMask)).getText();
    }

    public String getCvcInputFieldPlaceHolder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcFieldMask)).getText();
    }

    public String getCardHolderNameInputFieldPlaceHolder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderNameFieldMask)).getText();
    }

    public void openCardDataPage() {
        orcForm.selectCommunicationServicesPaymentType();
        orcForm.fillAndAcceptCommunicationServicesDataSection(TestData.INPUT_SUM);
        logger.info("Переход на форму заполнения данных о карте");
        switchToIFrame();
    }

    public List<By> getPaymentsLogo() {
        return Arrays.asList(visaLogo, masterCardLogo, mirLogo, maestroLogo, belCardLogo);
    }

    public String getPayDescriptionCostInputMaskText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payDescriptionCost)).getText();
    }

    public String getButtonSubmitPaymentInputMaskText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSubmitPayment)).getText();
    }

    public String getPhoneNumberShowHeaderInputMaskText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberShowHeader)).getText();
    }
}
