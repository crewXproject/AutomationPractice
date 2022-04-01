package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class signinPage {

    public signinPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id="email_create")
    public WebElement createEmailInput;

    @FindBy(xpath="//*[@id=\"SubmitCreate\"]/span")
    public WebElement createAccountBtn;

    @FindBy(id="email")
    public WebElement signinEmailInput;

    @FindBy(id="passwd")
    public WebElement signinPasswdInput;

    @FindBy(id="SubmitLogin")
    public WebElement signinBtn;


}
