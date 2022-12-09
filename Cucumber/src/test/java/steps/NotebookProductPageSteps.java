package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.pages.NotebookProductPage;

public class NotebookProductPageSteps {
    private static Logger logger = LogManager.getLogger(NotebookProductPageSteps.class);
    private NotebookProductPage notebookProductPage;

    /*
    public NotebookProductPageSteps(WebDriver driver){
        notebookProductPage = new NotebookProductPage(driver);
        logger.info("Открыта страница [Продукт. Ноутбук]");
    }
     */
    public String getPageTitle() {
        logger.info("Страница [Продукт. Ноутбук]: Получение заголовка страницы");
        return notebookProductPage.getPageTitle();
    }

    @Дано("Открыта страница \"Продукт. Ноутбук\"")
    public void openNotebookProductPage() {
        notebookProductPage = new NotebookProductPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Продукт. Ноутбук]: Открыта страница \"Продукт. Ноутбук\"");
    }

    @Тогда("Проверка: Заголовок страницы \"Продукт. Ноутбук\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(notebookProductPage.getPageTitle().contains(text),
                "Страница [Продукт. Ноутбук]: Ошибка! Заголовок страницы \"Продукт. Ноутбук\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Продукт. Ноутбук]: Заголовок страницы \"Продукт. Ноутбук\" содержит текст \"" + text + "\"");
    }

    @Тогда("Проверка: Название ноутбука соответсвует названию ноутбука в заголовке страницы")
    public void assertNotebookName() {
        Assertions.assertTrue(notebookProductPage.getPageTitle().contains(notebookProductPage.textTitleNotebookName().getText()),
                "Страница [Продукт. Ноутбук]: Ошибка! Название ноутбука в заголовке страницы не соответствует названию ноутбука на странице");
        logger.info("Страница [Продукт. Ноутбук]: Название ноутбука в заголовке страницы соответствует названию ноутбука на странице");
    }

    @Тогда("Проверка: Количество оперативной памяти в характеристиках равно {int}")
    public void assertRamValue(int ram) {
        Assertions.assertEquals(ram + "ГБ", notebookProductPage.textNotebookRamValue().getText().replaceAll("\\s+", ""),
                "Страница [Продукт. Ноутбук]: Ошибка! Количество оперативной памяти ноутбука не равно - " + ram + " ГБ");
        logger.info("Страница [Продукт. Ноутбук]: Количество оперативной памяти ноутбука равно - " + ram + " ГБ");
    }

    public String getTextTitleNotebookName() {
        logger.info("Страница [Продукт. Ноутбук]: Получение названия ноутбука на странице");
        return notebookProductPage.textTitleNotebookName().getText();
    }

    public String getTextTitleManufacture() {
        logger.info("Страница [Продукт. Ноутбук]: Получение компании производителя ноутбука");
        return notebookProductPage.textTitleManufacture().getText();
    }

    public String getNotebookRamValue() {
        logger.info("Страница [Продукт. Ноутбук]: Получение количества ОЗУ ноутбука");
        return notebookProductPage.textNotebookRamValue().getText();
    }

    @Когда("Нажата кнопка \"Развернуть все\"")
    public void pressMoreCharacteristic() {
        logger.info("Страница [Продукт. Ноутбук]: Нажатие кнопки 'Развернуть все'");
        notebookProductPage.btnDropDownCharacteristics.click();
        JavaScriptHelper.scrollBy(0,600);
    }
}
