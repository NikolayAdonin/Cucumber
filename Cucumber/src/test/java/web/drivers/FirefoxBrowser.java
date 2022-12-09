package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser {
    public static WebDriver getDriver(String pageLoadStrategy){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--private");
        firefoxOptions.addArguments("--kiosk");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.valueOf(pageLoadStrategy.toUpperCase()));
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }
}
