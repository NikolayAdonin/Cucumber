package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    private static Logger logger = LogManager.getLogger(ScreenshotHelper.class);
    private static WebDriver screenshotDriver;
    public static void init(WebDriver driver){
        screenshotDriver = driver;
    }

    public static void takeScreenshot(WebDriver driver, String eventName) {
        try {
            Actions actions = new Actions(driver);
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png",
                    new File("screenshots\\" + eventName));
            logger.info("Скриншот сохранен в файле [screenshots\\" + eventName + "]");
            JavaScriptHelper.scrollBy(0, -10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
