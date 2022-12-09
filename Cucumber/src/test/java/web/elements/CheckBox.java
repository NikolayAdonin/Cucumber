package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElement {
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    private boolean isChecked() {
        return webElement.isSelected();
    }

    public void setChecked(boolean value) {
        if (value != isChecked()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }
}
