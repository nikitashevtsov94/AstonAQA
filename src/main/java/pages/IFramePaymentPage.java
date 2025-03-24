package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFramePaymentPage extends BasePage {
    private final By iFrame = By.className("bepaid-iframe");
    private final By creditCardDataForm = By.xpath("//div[contains(@class,'card ng-tns')]");

    public IFramePaymentPage(WebDriver driver) {
        super(driver);
    }
    public void switchToIFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
    }

    public boolean isCardDataFormAvailable () {
         return wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardDataForm)) != null;
    }
}
