package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    private static Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    protected static JavascriptExecutor javascriptExecutor;
    static Long sleepTime = 3000L;

    public static void init(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        javascriptExecutor.executeScript(script);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        javascriptExecutor.executeScript(script,element);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
