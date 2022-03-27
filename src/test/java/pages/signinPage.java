package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class signinPage {

    public signinPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id="email_create")
    public WebElement emailInput;

    @FindBy(xpath="//*[@id=\"SubmitCreate\"]/span")
    public WebElement createAccountBtn;

}
