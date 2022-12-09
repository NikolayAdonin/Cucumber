package web.pages;

import web.elements.Button;
import web.elements.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotebookProductPage extends BasePage {
    private Logger logger = LogManager.getLogger(NotebooksPage.class);

    @FindBy(xpath = "//h1[@class='product-card-top__title']")
    public WebElement textTitleNotebookName;

    @FindBy(xpath = "//a[@class='product-card-tabs__title ui-link ui-link_black' and text() = 'Характеристики']")
    public WebElement btnCharacteristics;

    @FindBy(xpath = "//button[@class='button-ui button-ui_white product-characteristics__expand' and text() = 'Развернуть все']")
    public WebElement btnDropDownCharacteristics;

    @FindBy(xpath = "//div[@class='product-card-description__title']")
    public WebElement textTitleManufacture;

    @FindBy(xpath = "//div[@class='product-characteristics__spec-title' and text() = ' Объем оперативной памяти ']")
    public WebElement textCharacteristicName;

    //@FindBy(css = "product-characteristics__spec-value")
    //public List<WebElement> textsNotebookRamValue;

    @FindBy(xpath = "//div[@class='product-characteristics__spec-title' and text() = ' Объем оперативной памяти ']/following-sibling::div")
    public WebElement textsNotebookRamValue;

    public NotebookProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Text textTitleNotebookName() {
        return new Text(textTitleNotebookName);
    }

    public Button btnCharacteristics() {
        return new Button(btnCharacteristics);
    }

    public Button btnDropDownCharacteristics() {
        return new Button(btnDropDownCharacteristics);
    }
    public Text textTitleManufacture(){
        return new Text(textTitleManufacture);
    }

    public Text textCharacteristicName() {
        return new Text(textCharacteristicName);
    }

    public Text textNotebookRamValue() {
        return new Text(textsNotebookRamValue);
    }


}
