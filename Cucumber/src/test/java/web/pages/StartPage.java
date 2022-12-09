package web.pages;

import web.elements.Button;
import web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class StartPage extends BasePage {
    private Logger logger = LogManager.getLogger(StartPage.class);
    private String URL = "https://www.dns-shop.ru/";

    @FindBy(xpath = "//span[@class='base-ui-button-v2__text' and text() = 'Всё верно']")
    private WebElement buttonApplyCity;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__root-title' and text() = 'Бытовая техника']")
    private WebElement linkAppliances;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__first-level']")
    private List<WebElement> linksFirstLevel;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__second-level' and text() = 'Приготовление напитков']")
    private WebElement linkMakeDrinks;

    @FindBy(css = ".menu-desktop__popup-link")
    private List<WebElement> popUpElements;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__second-level' and text() = 'Плиты и печи']")
    private WebElement linkCookerAndFurnace;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__popup-link' and text() = 'Плиты электрические']")
    private WebElement linkElectricCooker;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__root-title' and text() = 'ПК, ноутбуки, периферия']")
    private WebElement linkPcNotebooksEtc;

    @FindBy(xpath = "//div[@class='menu-desktop__submenu menu-desktop__submenu_top']")
    private WebElement popUpSubMenu;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__second-level' and text() = 'Ноутбуки']")
    private WebElement linkNotebooks;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return this.URL;
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница: " + this.URL);
    }

    public Button buttonApplyCity() {
        return new Button(buttonApplyCity);
    }

    public Link linkRootCategory() {
        return new Link(linkAppliances);
    }

    public List<Link> linksFirstLevel() {
        List<Link> list = new ArrayList<>();
        for (WebElement tmp : linksFirstLevel)
            list.add(new Link(tmp));
        return list;
    }

    public Link linkMakeDrinks() {
        return new Link(linkMakeDrinks);
    }

    public List<Link> popUpElements() {
        List<Link> list = new ArrayList<>();
        for (WebElement tmp : popUpElements)
            list.add(new Link(tmp));
        return list;
    }

    public Link linkCookerAndFurnace() {
        return new Link(linkCookerAndFurnace);
    }

    public Link linkElectricCooker() {
        return new Link(linkElectricCooker);
    }

    public Link linkPcNotebooksEtc() {
        return new Link(linkPcNotebooksEtc);
    }

    public Link popUpSubMenu() {
        return new Link(popUpSubMenu);
    }

    public Link linkNotebooks() {
        return new Link(linkNotebooks);
    }

}
