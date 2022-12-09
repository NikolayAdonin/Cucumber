package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.ElectricCookersPage;

public class ElectricCookersPageSteps {
    private static Logger logger = LogManager.getLogger(ElectricCookersPageSteps.class);
    private ElectricCookersPage electricCookersPage;

    /*
    public ElectricCookersPageSteps(WebDriver driver) {
        electricCookersPage = new ElectricCookersPage(driver);
        logger.info("Открыта страница [Электрические плиты]");
    }
     */

    @Дано("Открыта страница \"Электрические плиты\"")
    public void openElectricCookersPage() {
        electricCookersPage = new ElectricCookersPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Электрические плиты]: Открыта страница \"Электрические плиты\"");
    }

    @Тогда("Проверка: Количество товаров на странице \"Электрические плиты\" больше {int}")
    public void assertItemCount(int count) {
        Assertions.assertTrue(Integer.parseInt(electricCookersPage.textItemCount().getText().replaceAll("\\D", "")) > count,
                "Страница [Электрические плиты]: Ошибка! Количество товаров на странице меньше чем " + count);
        logger.info("Страница [Электрические плиты]: Количество товаров на странице больше " + count);
    }

    public String getItemCount() {
        logger.info("Страница [Электрические плиты]: Полученик количества товаров на странице");
        return electricCookersPage.textItemCount().getText();
    }
}
