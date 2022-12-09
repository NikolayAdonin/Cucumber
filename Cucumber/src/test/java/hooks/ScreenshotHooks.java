package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.helpers.ScreenshotHelper;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class ScreenshotHooks {
    private Logger logger = LogManager.getLogger(ScreenshotHooks.class);

    @BeforeStep
    public void takeScreenshotBeforeStep(Scenario scenario) {
        //String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
        //ScreenshotHelper.takeScreenshot(WebDriverFactory.getCurrentDriver(),name);
        try {
            Screenshot screenshot = new AShot()
                    //.shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png",
                    new File("screenshots\\" + name));
            logger.info("Скриншот сохранен в файле [screenshots\\" + name + "]");
            //JavaScriptHelper.scrollBy(0, -10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        //String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
        //ScreenshotHelper.takeScreenshot(WebDriverFactory.getCurrentDriver(),name);
        try {
            Screenshot screenshot = new AShot()
                    //.shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png",
                    new File("screenshots\\" + name));
            logger.info("Скриншот сохранен в файле [screenshots\\" + name + "]");
            //JavaScriptHelper.scrollBy(0, -10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
