package web.pages;

import web.elements.Link;
import web.elements.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppliancesPage extends BasePage {
    private Logger logger = LogManager.getLogger(AppliancesPage.class);

    @FindBy(className = "subcategory__page-title")
    private WebElement textTitle;

    @FindBy(xpath = "//span[@class='subcategory__title' and text() = 'Техника для кухни']")
    private WebElement linkSubCategory;

    public AppliancesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Text textTitle() {
        return new Text(textTitle);
    }

    public Link linkSubCategory() {
        return new Link(linkSubCategory);
    }
}
