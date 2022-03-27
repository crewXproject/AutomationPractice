package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dressesPage {

    public dressesPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")
    public WebElement casualLink;


}
