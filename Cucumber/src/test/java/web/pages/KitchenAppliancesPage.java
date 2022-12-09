package web.pages;

import web.elements.Link;
import web.elements.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class KitchenAppliancesPage extends BasePage {
    private Logger logger = LogManager.getLogger(KitchenAppliancesPage.class);

    @FindBy(className = "subcategory__page-title")
    private WebElement textTitle;

    @FindBy(xpath = "//a[@class='button-ui button-ui_white configurator-links-block__links-link' and text() = 'Собрать свою кухню']")
    private WebElement linkCustomKitchen;

    @FindBy(xpath = "//span[@class='subcategory__title']")
    private List<WebElement> linksSubCategory;

    public KitchenAppliancesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Text textTitle() {
        return new Text(textTitle);
    }

    public Link linkCustomKitchen() {
        return new Link(linkCustomKitchen);
    }

    public List<Link> linksSubCategory() {
        List<Link> list = new ArrayList<>();
        for (WebElement tmp : linksSubCategory)
            list.add(new Link(tmp));
        return list;
    }
}
