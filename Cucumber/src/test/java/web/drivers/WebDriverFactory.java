package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriver driver;

    public static WebDriver getCurrentDriver() {
        return driver;
    }

    public static WebDriver getDriver(BrowserName name, String pageLoadStrategy) {
        switch (name) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                driver = ChromeBrowser.getDriver(pageLoadStrategy);
                break;
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                driver = FirefoxBrowser.getDriver(pageLoadStrategy);
                break;
            // Драйвер браузера Microsoft Edge
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
        return driver;
    }
}
