package web.pages;

import web.elements.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.*;

import java.util.List;

public class NotebooksPage extends BasePage {
    private Logger logger = LogManager.getLogger(NotebooksPage.class);

    @FindBy(xpath = "//header")
    public WebElement blockHeader;

    @FindBy(xpath = "//span[@class = ui-collapse__link-text and text() = 'Производитель']")
    public WebElement accordeonCompany;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]/../../div//label/span[1]")
    public List<WebElement> checkBoxCompany;

    @FindBy(xpath = "//span[@class='ui-collapse__link-text' and text() = 'Объем оперативной памяти (ГБ)']")
    public WebElement accordeonRAM;

    @FindBy(xpath = "//span[@class='ui-collapse__link-text' and text() = 'Объем оперативной памяти (ГБ)']/../../div//label/span[1]")
    public List<WebElement> checkBoxRam;

    @FindBy(xpath = "//span[@class='top-filter__selected' and text() = 'Сначала недорогие']")
    public WebElement accordeonSort;

    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]//span")
    public List<WebElement> radiobuttonSort;

    @FindBy(xpath = "//button[@data-role='filters-submit']")
    public WebElement buttonApplyFilter;

    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    public WebElement linkFirstProduct;

    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]//span")
    public WebElement textFirstProductName;

    public NotebooksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Block blockHeader() {
        return new Block(blockHeader);
    }

    public Accordeon accordeonCompany() {
        return new Accordeon(accordeonCompany);
    }

    public CheckBox checkBoxCompany(String company) {
        for (WebElement tmp : checkBoxCompany) {
            if (tmp.getText().contains(company))
                return new CheckBox(tmp);
        }
        return null;
    }

    public Accordeon accordeonRAM() {
        return new Accordeon(accordeonRAM);
    }

    public CheckBox checkBoxRam(String value) {
        for (WebElement tmp : checkBoxRam) {
            if (tmp.getText().contains(value))
                return new CheckBox(tmp);
        }
        return null;
    }

    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }

    public RadioButton radiobuttonSort(String type) {
        for (WebElement tmp : radiobuttonSort) {
            if (tmp.getText().toLowerCase().contains(type.toLowerCase()))
                return new RadioButton(tmp);
        }
        return null;
    }

    public Button buttonApplyFilter() {
        return new Button(buttonApplyFilter);
    }

    public Link linkFirstProduct() {
        return new Link(linkFirstProduct);
    }

    public Text textFirstProductName(){
        return new Text(textFirstProductName);
    }

}
