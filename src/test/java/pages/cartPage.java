package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {

    public cartPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@id='center_column']/p[2]/a[1]/span")
    public WebElement proceedCheckoutBtn;

    @FindBy(xpath="//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]")
    public WebElement addfirstItemBtn;
    
    @FindBy(xpath=" //*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    public WebElement ProceedChkBtn;
    
    @FindBy(xpath="//*[@id='cart_quantity_up_1_1_0_0']/span/i")
    public WebElement AddQtyUp;
    
    @FindBy(xpath="//*[@id='cart_quantity_down_1_1_0_0']")
    public WebElement QtyDownBtn;
    
    @FindBy(xpath="//*[@id='1_1_0_0']")
    public WebElement DeleteItems;
 

}
