package pages;

import org.openqa.selenium.By;

public class IFramePaymentPage {
    private final By iFrame = By.className("bepaid-iframe");
    private final By creditCardDataForm = By.xpath("//div[contains(@class,'card ng-tns')]");

    private static final String TEST_PHONE_NUMBER = "297777777";
    private static final String TEST_SUM = "10";
}
