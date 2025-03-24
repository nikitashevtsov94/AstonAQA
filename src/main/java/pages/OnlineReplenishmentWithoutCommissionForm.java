package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
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
    private final By phoneNumberInputField = By.id("connection-phone");
    private final By moneySumInputField = By.id("connection-sum");
    private final By continuePayFormButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
    private final By actualListSelection = By.xpath("//span[@class='select__now']");
    private final Logger logger = Logger.getLogger(OnlineReplenishmentWithoutCommissionForm.class.getName());

    private static final String TEST_PHONE_NUMBER = "297777777";
    private static final String TEST_SUM = "10";

    public OnlineReplenishmentWithoutCommissionForm(WebDriver driver) {
        super(driver);
    }

    public String getOrcFormHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formHeader)).getText().replace("\n", StringUtils.SPACE);
    }

    public boolean isLogoPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info(String.format("Логотип %s отображается на странице", locator));
        } catch (TimeoutException e) {
            logger.info("Найден логотип" + locator);
            return false;
        }
        return true;
    }

    public List<By> getPaymentsLogo() {
        return Arrays.asList(visaLogo, verifiedByVisa, masterCard, masterCardSecureCode, belCard);
    }

    public void detailsHyperTextClick() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceDetailsHyperText)).click();
    }

    public void typePhoneNumber() {
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInputField)).click();
        driver.findElement(phoneNumberInputField).sendKeys(TEST_PHONE_NUMBER);
    }

    public void typePaymentSum(int sum) {
        wait.until(ExpectedConditions.elementToBeClickable(moneySumInputField)).click();
        driver.findElement(moneySumInputField).sendKeys(String.valueOf(sum));
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continuePayFormButton)).click();
    }

    public void fillCommunicationServicesDataSection(int sum) {
        typePhoneNumber();
        typePaymentSum(sum);
        clickContinueButton();
        logger.info("Нажата кнопка продолжить на форме пополнения счета");
    }

    public String getActualPaymentSection() {
        return driver.findElement(actualListSelection).getText();
    }


}
