package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;


public class BasePage {

    private final Logger logger = Logger.getLogger(BasePage.class.getName());

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.WAIT_DURATION));
    }

    public void loadBaseUrl() {
        driver.manage().window().maximize();
        driver.get(TestData.MTS_URL);
        try {
            wait.until(ExpectedConditions.titleIs(TestData.BASE_URL_HEADER));
            logger.info(String.format("Страница %s загружена.%n", TestData.MTS_URL));
        } catch (TimeoutException e) {
            logger.info(String.format("Не удалось загрузить страницу %s.%n%s", TestData.MTS_URL, e.getMessage()));
        }
    }

    public boolean isLogoPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info(String.format("Логотип %s найден на странице", locator));
        } catch (TimeoutException e) {
            logger.info("Не найден логотип" + locator);
            return false;
        }
        return true;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
