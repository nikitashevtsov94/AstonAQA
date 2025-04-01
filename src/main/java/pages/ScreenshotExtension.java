package pages;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class ScreenshotExtension implements TestWatcher {
    private final Supplier<WebDriver> driverSupplier;
    private final Logger logger = Logger.getLogger(ScreenshotExtension.class.getName());

    public ScreenshotExtension(Supplier<WebDriver> driverSupplier) {
        this.driverSupplier = driverSupplier;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        WebDriver driver = driverSupplier.get();
        System.out.println("🔥 Получен WebDriver: " + driver); // Проверка, что драйвер существует

        if (driver == null) {
            System.err.println("❌ Ошибка: WebDriver не инициализирован!");
            return;
        }
        if (driver instanceof TakesScreenshot) {
            System.out.println("📷 WebDriver поддерживает скриншоты!");
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotName = "target/screenshots/" + context.getDisplayName() + ".png";
                Files.copy(screenshot.toPath(), Paths.get(screenshotName));
                System.out.println("Скриншот сохранен: " + screenshotName);
                System.out.println("📷 Вызов attachScreenshot()");
                attachScreenshot(driver);
            } catch (IOException e) {
                logger.severe("Ошибка сохранения скриншота: " + e.getMessage());
            }
        } else {
            System.err.println("❌ WebDriver НЕ поддерживает скриншоты!");
        }
    }

    @Attachment(value = "Скриншот при падении теста", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
