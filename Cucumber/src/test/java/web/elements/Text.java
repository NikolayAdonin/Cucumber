package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class Text extends BaseElement {
    public Text(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        WaitHelper.visibilityOfElement(webElement);
        return webElement.getText();
    }
}
