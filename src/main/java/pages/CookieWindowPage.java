package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class CookieWindowPage extends BasePage {
    private final By cookieAgreeButton = By.id("cookie-agree");
    private final Logger logger = Logger.getLogger(CookieWindowPage.class.getName());
    public CookieWindowPage(WebDriver driver) {
        super(driver);
    }
    public void acceptCookie() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieAgreeButton)).click();
        } catch (TimeoutException e) {
            logger.info("Cookie-форма не отобразилась" + e.getMessage());
        }
    }
}
