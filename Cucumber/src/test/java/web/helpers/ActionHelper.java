package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {
    private static Logger logger = LogManager.getLogger(ActionHelper.class);
    protected static Actions actions;

    public static void init(WebDriver driver) {
        actions = new Actions(driver);
    }
    public static void moveToElement(WebElement webElement){
        actions.moveToElement(webElement).perform();
    }
}
