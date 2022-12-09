package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverListener;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Selenium4Listener implements WebDriverListener {
    private Logger logger = LogManager.getLogger(Selenium4Listener.class);

    private String elementDescription(WebElement element) {
        String description = "tag:" + element.getTagName();
        if (element.getAttribute("id") != null || element.getAttribute("id").isBlank()) {
            description += " id: " + element.getAttribute("id");
        } else if (element.getAttribute("name") != null) {
            description += " name: " + element.getAttribute("name");
        }
        description += " ('" + element.getText() + "')";
        return description;
    }

    @Override
    public void beforeClick(WebElement element) {
        if (!elementDescription(element).isEmpty() || !elementDescription(element).isBlank())
            logger.info("Произведено нажатие: " + elementDescription(element));
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        if (!elementDescription(result).isEmpty() || !elementDescription(result).isBlank())
            logger.info("Найдет элемент: " + elementDescription(result));
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        logger.info("Найдены элементы:");
        for (WebElement tempElement : result)
            if (!elementDescription(tempElement).isEmpty() || !elementDescription(tempElement).isBlank())
                logger.info(elementDescription(tempElement));
    }

    /*@Override
    public void afterGetText(WebElement element, String result) {
        logger.info("Получен текст: " + result);
    }
    */

}
