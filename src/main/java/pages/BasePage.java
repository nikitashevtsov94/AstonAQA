package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {
    private final By payFormWrapper = By.className("pay__wrapper");

    private static final int WAIT_DURATION = 5;
    private static final String MTS_URL = "https://www.mts.by/";
    private static final String BASE_URL_HEADER = "МТС – мобильный оператор в Беларуси";
    private final Logger logger = Logger.getLogger(BasePage.class.getName());

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
    }

    public void loadBaseUrl() {
        driver.manage().window().maximize();
        driver.get(MTS_URL);
        try {
            wait.until(ExpectedConditions.titleIs(BASE_URL_HEADER));
            logger.info(String.format("Страница %s загружена.%n", MTS_URL));
        } catch (TimeoutException e) {
            logger.info(String.format("Не удалось загрузить страницу %s.%n", MTS_URL) + e.getMessage());
        }
    }

    public void checkPayFormLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payFormWrapper));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
