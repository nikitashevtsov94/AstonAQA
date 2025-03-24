package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public OnlineReplenishmentWithoutCommissionForm(WebDriver driver) {
        super(driver);
    }
    public String getOrcFormHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formHeader))
                .getText().replace("\n", StringUtils.SPACE);
    }
}
