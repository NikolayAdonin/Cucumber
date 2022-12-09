package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.KitchenAppliancesPage;

public class KitchenAppliancesPageSteps {
    private static Logger logger = LogManager.getLogger(KitchenAppliancesPageSteps.class);
    private KitchenAppliancesPage kitchenAppliancesPage;

    /*
    public KitchenAppliancesPageSteps(WebDriver driver) {
        kitchenAppliancesPage = new KitchenAppliancesPage(driver);
        logger.info("Открыта страница [Техника для кухни]");
    }
     */

    @Дано("Открыта страница \"Техника для кухни\"")
    public void openKitchenAppliancesPage() {
        kitchenAppliancesPage = new KitchenAppliancesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Техника для кухни]: Открыта страница \"Техника для кухни\"");
    }

    @Тогда("Проверка: На странице Техника для кухни отображается текст {string}")
    public void assertTitle(String text) {
        logger.info(kitchenAppliancesPage.textTitle().getText());
        Assertions.assertEquals(kitchenAppliancesPage.textTitle().getText(),text,
                "Страница [Техника для кухни]: Ошибка! Текст " + text + " не отображается на странице");
        logger.info("Страница [Техника для кухни]: Текст  " + text + " отображается на странице");
    }

    @Тогда("Проверка: Отображается ссылка \"Собрать свою кухню\"")
    public void assertLinkCustomKitchen() {
        Assertions.assertTrue(kitchenAppliancesPage.linkCustomKitchen().visibility(),
                "Страница [Техника для кухни]: Ошибка! Ссылка \"Собрать свою кухню\" не отображается");
        logger.info("Страница [Техника для кухни]: Ссылка \"Собрать свою кухню\" отображается");
    }

    @Тогда("Проверка: Количество категорий на странице больше {int}")
    public void assertCategoryMoreThan(int count) {
        Assertions.assertTrue(kitchenAppliancesPage.linksSubCategory().size() > count,
                "Страница [Техника для кухни]: Ошибка! Количество категорий на странице меньше или равно " + count);
        logger.info("Страница [Техника для кухни]: Количество категорий больше " + count);
    }

    public String getTextTitle() {
        logger.info("Страница [Техника для кухни]: Получение текста 'Техника для кухни' на странице");
        return kitchenAppliancesPage.textTitle().getText();
    }

    public Boolean getLinkCustomKitchenVisibility() {
        logger.info("Страница [Техника для кухни]: Отображение ссылки 'Собрать свою кухню'");
        return kitchenAppliancesPage.linkCustomKitchen().visibility();
    }

    public int getLinksSubCategoryCount() {
        logger.info("Страница [Техника для кухни]: Получение количества категорий на странице");
        return kitchenAppliancesPage.linksSubCategory().size();
    }
}
