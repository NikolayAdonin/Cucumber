package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class RadioButton extends BaseElement {
    public RadioButton(WebElement webElement) {
        super(webElement);
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public void setSelected(boolean value) {
        if (value != isSelected()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }
}
