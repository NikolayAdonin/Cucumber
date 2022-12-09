package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.AppliancesPage;

public class AppliancesPageSteps {
    private static Logger logger = LogManager.getLogger(AppliancesPageSteps.class);
    private AppliancesPage appliancesPage;

    /*
    public AppliancesPageSteps(WebDriver driver) {
        appliancesPage = new AppliancesPage(driver);
        logger.info("Открыта страница [Бытовая техника]");
    }
     */

    @Дано("Открыта страница \"Бытовая техника\"")
    public void openAppliancesPage() {
        appliancesPage = new AppliancesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Бытовая техника]: Открыта страница \"Бытовая техника\"");
    }

    @Тогда("Проверка: На странице Бытовая техника отображается текст {string}")
    public void assertTextTitle(String text) {
        logger.info(appliancesPage.textTitle().getText());
        Assertions.assertTrue(appliancesPage.textTitle().getText().contains(text),
                "Страница [Бытовая техника]: Ошибка! На странице не отображается текст " + text);
        logger.info("Страница [Бытовая техника]: На странице отображается текст " + text);
    }

    @Когда("Выполнен переход на страницу \"Техника для кухни\"")
    public void goToKitchenAppliancesPage() {
        appliancesPage.linkSubCategory().click();
        logger.info("Страница [Бытовая техника]: Переход на страницу 'Техника для кухни'");
    }

    public String getTextTitle() {
        logger.info("Страница [Бытовая техника]: Получение текста 'Бытовая техника' на старнице");
        return appliancesPage.textTitle().getText();
    }
}
