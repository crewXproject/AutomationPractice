package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {

    public cartPage() {PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
    public WebElement summaryChkoutBtn;

    @FindBy(name="processAddress")
    public WebElement addressChkoutBtn;

    @FindBy(xpath="//*[@id=\"address_delivery\"]/li[7]/a/span")
    public WebElement updateBtn;

    @FindBy(xpath="//*[@id=\"cgv\"]")
    public WebElement agreeChkbox;

    @FindBy(xpath="//*[@id=\"form\"]/p/button/span")
    public WebElement shippingChkoutBtn;

    @FindBy(name="message")
    public WebElement messageBox;

    @FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a/span")
    public WebElement payByBankWireBtn;

    @FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a/span")
    public WebElement payByCheckBtn;

    @FindBy(xpath="//*[@id=\"product_4_16_0_664403\"]/td[2]/p/a")
    public WebElement printedDesc;

    @FindBy(xpath="//*[@id=\"product_7_34_0_664403\"]/td[2]/p/a")
    public WebElement chiffonDesc;

    @FindBy(xpath="//*[@id=\"center_column\"]/form/div/p[1]")
    public WebElement checkPaymentDesc;

    @FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span")
    public WebElement iConfirmOrderBtn;

    @FindBy(xpath="//*[@id=\"center_column\"]/p[1]")
    public WebElement checkMsg;

    @FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
    public WebElement bankWireMsg;

    @FindBy(xpath="//*[@id=\"home-page-tabs\"]/li[1]/a")
    public WebElement popularLabel;

    @FindBy(xpath="//*[@id=\"submitAddress\"]/span")
    public WebElement saveBtn;

}
