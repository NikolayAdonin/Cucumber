package tests.matchers;

import org.junit.jupiter.api.Assertions;
import steps.AppliancesPageSteps;

public class AppliancesPageMatcher {
    AppliancesPageSteps pageSteps;
    public AppliancesPageMatcher(AppliancesPageSteps pageSteps){
        this.pageSteps = pageSteps;
    }
    public void pageTitleEquals(String expected){
        String actual = pageSteps.getTextTitle();
        Assertions.assertEquals(expected,actual,"Текст 'Бытовая техника' не отображается");
    }
}
