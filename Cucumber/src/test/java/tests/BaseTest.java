package tests;

import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriver eventFiringDriver;
    Selenium4Listener listener = new Selenium4Listener();
    String envPageLoadStrategy = System.getProperty("loadstrategy", "normal");
    private Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp() {
        String browser = System
                .getProperty("browser","chrome")
                .toLowerCase();
        logger.info("env = " + BrowserName.fromString(browser) + " + " + envPageLoadStrategy);
        eventFiringDriver = WebDriverFactory.getDriver(BrowserName.fromString(browser), envPageLoadStrategy.toLowerCase());
        driver = new EventFiringDecorator<>(listener).decorate(eventFiringDriver);
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

}
