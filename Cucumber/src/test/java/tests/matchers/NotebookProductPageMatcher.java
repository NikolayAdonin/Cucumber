package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.NotebookProductPageSteps;

public class NotebookProductPageMatcher {
    NotebookProductPageSteps pageSteps;
    private Logger logger = LogManager.getLogger(NotebookProductPageMatcher.class);

    public NotebookProductPageMatcher(NotebookProductPageSteps pageSteps) {
        this.pageSteps = pageSteps;
    }

    public void pageTitleEquals(String expected) {
        String actualTitle = pageSteps.getPageTitle();
        Assertions.assertTrue(actualTitle.contains(expected), "Название ноутбука не соответсвует названию в заголовке страницы");
    }

    public void pageNotebookNameEquals(String expected) {
        String actualNotebookName = pageSteps.getTextTitleNotebookName();
        Assertions.assertTrue(expected.contains(actualNotebookName), "Название ноутбука не соответсвует названию на прошлой странице");
    }

    public void pageManufactureContains(String expected) {
        String actualManufacture = pageSteps.getTextTitleManufacture();
        Assertions.assertTrue(actualManufacture.contains(expected), "Заголовок не содержит 'ASUS'");
    }

    public void pageNotebookRamValueEquals(String expected) {
        String actualRamValue = pageSteps.getNotebookRamValue();
        Assertions.assertEquals(expected + "ГБ", actualRamValue.replaceAll("\\s+", ""), "Количество оперативной памяти != " + expected + " Гб");
    }
}
