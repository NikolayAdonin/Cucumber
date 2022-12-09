package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.StartPage;

public class StartPageSteps {
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private StartPage startPage;

    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта \"Стартовая страница сайта DNS\"");
    }

    @Когда("Нажата кнопка \"Всё верно\"")
    public void pressButtonApplyCity() {
        startPage.buttonApplyCity().click();
        logger.info("Страница [Стартовая страница DNS]: Нажата кнопка 'Всё верно'");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    public StartPageSteps(WebDriver driver) {
        startPage = new StartPage(driver);
        startPage.openPage();
        logger.info("Открыта страница [Стартовая страница DNS]");
    }
     */
    @Когда("Выполнен переход на страницу \"Бытовая техника\"")
    public void goToAppliancesPage() {
        startPage.linkRootCategory().focusOnLink();
        startPage.linkRootCategory().click();
        logger.info("Страница [Стартовая страница DNS]: Переход на страницу 'Бытовая техника'");
    }

    @Когда("Выполнен переход на страницу \"Электрические плиты\"")
    public void goToElectricCookersPage() {
        startPage.linkRootCategory().focusOnLink();
        startPage.linkCookerAndFurnace().focusOnLink();
        startPage.linkElectricCooker().focusOnLink();
        startPage.linkElectricCooker().click();
        logger.info("Страница [Стартовая страница DNS]: Переход на страницу 'Электрические плиты'");
    }

    @Когда("Выполнен переход на страницу \"Ноутбуки\"")
    public void goToNotebooksPage() {
        startPage.linkPcNotebooksEtc().focusOnLink();
        startPage.linkNotebooks().focusOnLink();
        startPage.linkNotebooks().click();
        logger.info("Страница [Стартовая страница DNS]: Переход на страницу 'Ноутбуки'");
    }
}
