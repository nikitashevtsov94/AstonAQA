package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFramePaymentPage extends BasePage {
    private final By iFrame = By.className("bepaid-iframe");
    private final By creditCardDataForm = By.xpath("//div[contains(@class,'card ng-tns')]");
    private final By payDescriptionCost = By.xpath("//span[normalize-space()='10.00 BYN']");
    private final By buttonSubmitPayment = By.xpath("//button[contains(text(), 'Оплатить')]");
    private final By cardNumberFieldMask = By.xpath("//label[contains(text(), 'Номер карты')]");
    private final By cardExpirationDateFieldMask = By.xpath("//label[contains(text(), 'Срок действия')]");
    private final By cvcFieldMask = By.xpath("//label[contains(text(), 'CVC')]");
    private final By cardHolderNameFieldMask = By.xpath("//label[contains(text(), 'Имя держателя')]");
    private final By phoneNumberShowHeader = By.xpath("//span[contains(text(),'Оплата')]");
    private final By visaLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']']");
    private final By masterCardLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    private final By belCardLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    private final By maestroLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");
    private final By mirLogo = By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']");

    public IFramePaymentPage(WebDriver driver) {
        super(driver);
    }

    public void switchToIFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
    }

    public boolean isCardDataFormAvailable() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardDataForm)) != null;
    }

    public boolean hasMaestroLogo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(maestroLogo)) != null;
    }

    public boolean hasMirLogo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mirLogo)) != null;
    }
}
