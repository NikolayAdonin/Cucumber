package web.pages;

import web.elements.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectricCookersPage extends BasePage{
    private Logger logger = LogManager.getLogger(ElectricCookersPage.class);

    @FindBy(xpath = "//span[@data-role='items-count']")
    private WebElement textItemCount;

    public ElectricCookersPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public Text textItemCount(){
        return new Text(textItemCount);
    }

}
