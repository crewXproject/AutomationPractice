package pages;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dressesPage {

    public dressesPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")
    public WebElement casualLink;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    public WebElement tshirtLink;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    public WebElement dressLink;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")
    public WebElement eveningDressesLink;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
    public WebElement summerDressesLink;

    @FindBy(xpath="//a[contains(@href,'id_product=4')][@class='product-name']")
    public WebElement printedDress;

    @FindBy(xpath="//a[@title='Printed Chiffon Dress'][@class='product-name'][@itemprop='url']")
    public WebElement chiffonDress;

    @FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
    public WebElement fadeTshirt;

    @FindBy(id="quantity_wanted")
    public WebElement qtyBox;

    public void qtyInput(String qty) {
        qtyBox.clear();
        qtyBox.sendKeys(qty, Keys.ENTER);
    }

    @FindBy(xpath="//*[@id=\"group_1\"]")
    public WebElement sizeBox;

    public void sizeDropdown(String value) {
        sizeBox.click();
        Select select = new Select(sizeBox);
        select.selectByValue(value);
    }

    @FindBy(xpath="//*[@id=\"color_7\"]")
    public WebElement beigeColorBox;

    @FindBy(xpath="//*[@id=\"color_16\"]")
    public WebElement yellowColorBox;

    @FindBy(xpath="//*[@id=\"color_14\"]")
    public WebElement blueColorBox;

    @FindBy(xpath="//*[@id=\"attributes\"]/fieldset[2]/label")
    public WebElement colorLabel;

    @FindBy(xpath="//button[@name='Submit']")
    public WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    public WebElement checkoutBtn;

    @FindBy(xpath="//a[starts-with(@title,'Printed')][contains(text(),'Dress')][@itemprop='url']")
    public List<WebElement> dressSearch;

}
