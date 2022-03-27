package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class commonPage {

    public commonPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    public WebElement womenMenu;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    public WebElement dressesMenu;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    public WebElement tshirtsMenu;

    @FindBy(id="search_query_top")
    public WebElement searchInput;

    @FindBy(xpath="//*[@id=\"searchbox\"]/button")
    public WebElement searchButton;

    @FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    public WebElement signinMenu;

    @FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b")
    public WebElement cartMenu;

}
