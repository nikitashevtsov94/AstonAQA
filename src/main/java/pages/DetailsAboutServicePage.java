package pages;

import org.openqa.selenium.WebDriver;


public class DetailsAboutServicePage extends BasePage {

    public DetailsAboutServicePage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        if (driver.getTitle() == null) {
            throw new IllegalArgumentException("Заголовок страницы пуст");
        }
        return driver.getTitle();
    }
}
