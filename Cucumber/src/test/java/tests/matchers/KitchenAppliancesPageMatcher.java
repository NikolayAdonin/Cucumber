package tests.matchers;

import org.junit.jupiter.api.Assertions;
import steps.KitchenAppliancesPageSteps;

public class KitchenAppliancesPageMatcher {
    KitchenAppliancesPageSteps pageSteps;

    public KitchenAppliancesPageMatcher(KitchenAppliancesPageSteps pageSteps) {
        this.pageSteps = pageSteps;
    }

    public void pageTitleEquals(String expected) {
        String actual = pageSteps.getTextTitle();
        Assertions.assertEquals(expected, actual, "Текст 'Техника для кухни' не отображается");
    }

    public void pageLinkCustomKitchenVisibility(Boolean expected) {
        Boolean actual = pageSteps.getLinkCustomKitchenVisibility();
        Assertions.assertEquals(expected, actual, "Ссылка 'Собрать свою кухню' не отображается");
    }

    public void pageSubCategoryMoreThan(int expected) {
        int actual = pageSteps.getLinksSubCategoryCount();
        Assertions.assertTrue(actual > expected, "Количество категорий > " + expected);
    }
}
