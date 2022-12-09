package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {
    public static WebDriver getDriver(String pageLoadStrategy) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.valueOf(pageLoadStrategy.toUpperCase()));
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}
