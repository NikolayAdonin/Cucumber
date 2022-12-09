package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.Notebook;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.pages.NotebooksPage;

import java.util.Map;

public class NotebooksPageSteps {
    private static Logger logger = LogManager.getLogger(NotebooksPageSteps.class);
    private NotebooksPage notebooksPage;

    /*
    public NotebooksPageSteps(WebDriver driver) {
        notebooksPage = new NotebooksPage(driver);
        logger.info("Открыта страница [Ноутбуки]");
    }
    */

    @Дано("Открыта страница \"Ноутбуки\"")
    public void openNotebooksPage() {
        notebooksPage = new NotebooksPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Ноутбуки]: Открыта страница \"Ноутбуки\"");
    }

    @Когда("Спрятан блок \"header\"")
    public void hideBlockHeader() {
        notebooksPage.blockHeader().hide();
        logger.info("Страница [Ноутбуки]: Скрытие блока");
    }

    public String getFirstProductName() {
        logger.info("Страница [Ноутбуки]: Получение названия первого ноутбука в списке");
        return notebooksPage.textFirstProductName().getText();
    }

    @Когда("В фильтре \"Производитель\" выбрано значение {string}")
    public void filterByCompany(String company) {
        JavaScriptHelper.scrollBy(0, 1000);
        notebooksPage.checkBoxCompany(company).setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра 'Производитель' - " + company);
    }

    /*
    @Когда("В фильтре \"Объем оперативной памяти\" выбрано значение \"32 ГБ\"")
    public void filterByRam() {
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.accordeonRAM().show();
        notebooksPage.checkBoxRam(32 + " ГБ").setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра 'Объем оперативной памяти' - " + 32 + " ГБ");
    }
     */

    @Когда("В фильтре \"Объем оперативной памяти\" выбрано значение \"{int} ГБ\"")
    public void filterByRam(int ram) {
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.accordeonRAM().show();
        notebooksPage.checkBoxRam(ram + " ГБ").setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра 'Объем оперативной памяти' - " + ram + " ГБ");
    }

    @Когда("Применены фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.buttonApplyFilter().click();
        logger.info("Страница [Ноутбуки]: Нажата кнопка применить");
        JavaScriptHelper.scrollBy(0, -5000);
    }

    @И("Установлены фильтры из таблицы с двумя колонками")
    public void setFiltersFromTable(Map<String,String> filters){
        Notebook notebook = new Notebook(
                new Ram(Integer.parseInt(filters.get("Объем оперативной памяти").split(" ")[0])),
                new Company(filters.get("Производитель")));
        filterByCompany(notebook.getCompany().getCompany());
        filterByRam(notebook.getRam().getRam());
    }

    @Когда("Установлена сортировка {string}")
    public void orderBy(String type) {
        notebooksPage.accordeonSort().show();
        notebooksPage.radiobuttonSort(type).setSelected(true);
        logger.info("Страница [Ноутбуки]: Установка соритровки <" + type + ">");
        JavaScriptHelper.scrollBy(0, 600);
    }

    @Когда("Выполнен переход на страницу первого продукат в списке")
    public void goToFirstProduct() {
        JavaScriptHelper.scrollBy(0, -2000);
        notebooksPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Ноутбуки]: Открытие страницы первого продукта в списке в новом окне");
    }

    @Тогда("Проверка: Заголовок страницы \"Ноутбуки\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(notebooksPage.getPageTitle().contains(text),
                "Страница [Ноутбуки]: Ошибка! Заголовок страницы \"Ноутбуки\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Ноутбуки]: Заголовок страницы \"Ноутбуки\" содержит текст \"" + text + "\"");
    }

}
