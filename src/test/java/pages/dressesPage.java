package pages;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class dressesPage {

    public dressesPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")
    public WebElement casualLink;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    public WebElement dressLink;

    @FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")
    public WebElement eveningDressesLink;

    @FindBy(xpath="//a[contains(@href,'id_product=4')][@class='product-name']")
    public WebElement printedDress;

    @FindBy(id="quantity_wanted")
    public WebElement qtyBox;

    public void qtyInput(String qty) {
        qtyBox.clear();
        qtyBox.sendKeys(qty, Keys.ENTER);
    }

    @FindBy(id="group_1")
    public WebElement sizeBox;

    public void sizeDropdown(String value) {
        sizeBox.click();
        Select select = new Select(sizeBox);
        select.selectByVisibleText(value);
    }

    @FindBy(xpath="//a[@name='Beige']")
    public WebElement colorBox;

    @FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
    public WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    public WebElement checkoutBtn;


}
