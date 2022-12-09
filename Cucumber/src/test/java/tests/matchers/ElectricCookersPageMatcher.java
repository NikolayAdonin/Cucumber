package tests.matchers;

import org.junit.jupiter.api.Assertions;
import steps.ElectricCookersPageSteps;

public class ElectricCookersPageMatcher {
    ElectricCookersPageSteps pageSteps;

    public ElectricCookersPageMatcher(ElectricCookersPageSteps pageSteps) {
        this.pageSteps = pageSteps;
    }

    public void pageItemCountMoreThan(int expectedCount) {
        String actualCount = pageSteps.getItemCount().replaceAll("\\D", "");
        Assertions.assertTrue(Integer.parseInt(actualCount) > expectedCount, "Количество товаров > " + expectedCount);
    }
}
