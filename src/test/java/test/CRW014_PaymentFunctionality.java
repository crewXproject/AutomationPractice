package test;

import driver.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ListernersTestNG;
import utilities.PropertiesReader;
import utilities.commonMethods;

@Listeners(ListernersTestNG.class)
public class CRW014_PaymentFunctionality extends commonMethods{

	@BeforeMethod
	public void launchBrowser() {
//		1.User open browser and navigate to http://automationpractice.com/index.php
		Driver.getDriver();
	}

	@Test(priority = 1)
	public void CRW014_PayByCheck() {
//		2.Click on sign in menu located on the top of homepage.
		comm.signinMenu.click();

//		3.User can enter email address and password and then click sign in to account.
		signin.signinEmailInput.sendKeys(PropertiesReader.getProperty("CRW014.email"));
		signin.signinPasswdInput.sendKeys(PropertiesReader.getProperty("CRW014.password"));
		signin.signinBtn.click();

//		4.Webpage will navigate user to My Account.
		Assert.assertEquals(driver.getTitle(),PropertiesReader.getProperty("CRW014.myaccount"));

//		5.User can click "DRESS" button choose "EVENING DRESS" add item to the cart and click add to the cart.
		Actions action = new Actions(driver);
		action.moveToElement(dresses.dressLink).build().perform();
		dresses.eveningDressesLink.click();
		dresses.printedDress.click();
		wait.until(ExpectedConditions.visibilityOf(dresses.addToCartBtn));
		dresses.addToCartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(dresses.checkoutBtn));
		dresses.checkoutBtn.click();

//		6.Webpage will navigate user to summary order and then user can click to proceed check out.
		wait.until(ExpectedConditions.visibilityOf(cart.summaryChkoutBtn));
		cart.summaryChkoutBtn.click();

//		7.Next webpage will navigate user to delivery address and billing address details and user can update and comment all details and then click proceed to checkout.
		cart.messageBox.sendKeys(PropertiesReader.getProperty("CRW014.message"));
		cart.addressChkoutBtn.click();

//		8.Webpage will navigate user to shipping details user can click on term of service and then click proceed to check out.
		cart.agreeChkbox.click();
		cart.shippingChkoutBtn.click();

//		9.Webpage will navigate user to  all details and payment about item : product,description,avail,unitprice,Qty and total.User click payment (pay by bank check).
		cart.payByCheckBtn.click();

//		10.User will see all details about payment (pay by check) and then click "I confirm order".
		cart.iConfirmOrderBtn.click();

//		11.Webpage will be display "Your order on My Store is complete".
		Assert.assertEquals(cart.checkMsg.getText(),PropertiesReader.getProperty("CRW014.ordermsg"));
	}

	@Test(priority = 2)
	public void CRW014_PayByBankWire() {
//		2.Click on sign in menu located on the top of homepage.
		comm.signinMenu.click();

//		3.User can enter email address and password and then click sign in to account.
		signin.signinEmailInput.sendKeys(PropertiesReader.getProperty("CRW014.email"));
		signin.signinPasswdInput.sendKeys(PropertiesReader.getProperty("CRW014.password"));
		signin.signinBtn.click();

//		4.Webpage will navigate user to My Account.
		Assert.assertEquals(driver.getTitle(),PropertiesReader.getProperty("CRW014.myaccount"));

//		5.User can click "DRESS" button choose "SUMMER DRESS" add Printed Chiffon Dress and then click add to the cart.
		Actions action = new Actions(driver);
		action.moveToElement(dresses.dressLink).build().perform();
		dresses.summerDressesLink.click();
		dresses.chiffonDress.click();
		dresses.qtyInput("2");
		wait.until(ExpectedConditions.visibilityOf(dresses.addToCartBtn));
		dresses.addToCartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(dresses.checkoutBtn));
		dresses.checkoutBtn.click();

//		6.Webpage will navigate user to summary order and then user can click to proceed check out.
		cart.summaryChkoutBtn.click();

//		7.Next webpage will navigate user to delivery address and billing address details and user can update and comment all details and then click proceed to checkout.
		cart.messageBox.sendKeys(PropertiesReader.getProperty("CRW014.message"));
		cart.addressChkoutBtn.click();

//		8.Webpage will navigate user to shipping details user can click on term of service and then click proceed to check out.
		cart.agreeChkbox.click();
		cart.shippingChkoutBtn.click();

//		9.Webpage will navigate user to  all details and payment about item : product,description,avail,unitprice,Qty and total.User click payment (pay by bank wire).
		cart.payByBankWireBtn.click();

//		10.User will see all details about payment (pay by bank wire) and then click "I confirm order".
		cart.iConfirmOrderBtn.click();

//		11.Webpage will be display "Your order on My Store is complete".
		Assert.assertEquals(cart.bankWireMsg.getText(),PropertiesReader.getProperty("CRW014.ordermsg"));
	}

	@Test(priority = 3)
	public void CRW014_PayByCheckAndUpdateAddress() {
//		2.Click on sign in menu located on the top of homepage.
		comm.signinMenu.click();

//		3.User can enter email address and pass                                                               word and then click sign in to account.
		signin.signinEmailInput.sendKeys(PropertiesReader.getProperty("CRW014.email"));
		signin.signinPasswdInput.sendKeys(PropertiesReader.getProperty("CRW014.password"));
		signin.signinBtn.click();

//		4.Webpage will navigate user to My Account.
		Assert.assertEquals(driver.getTitle(),PropertiesReader.getProperty("CRW014.myaccount"));

//		5.User can click "T-Shirt" button add item to the cart and click add to the cart.
		dresses.tshirtLink.click();
		dresses.fadeTshirt.click();
		dresses.qtyInput("3");
		wait.until(ExpectedConditions.visibilityOf(dresses.addToCartBtn));
		dresses.addToCartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(dresses.checkoutBtn));
		dresses.checkoutBtn.click();

//		6.Webpage will navigate user to summary order and then user can click to proceed check out.
		cart.summaryChkoutBtn.click();

//		7.Next webpage will navigate user to delivery address and billing address details and
//		user click to update delivery address and phone number and click save and then
//		click proceed to checkout after you save you will see new delivery address and then click proceed to check out.
		cart.updateBtn.click();
		cart.saveBtn.click();
		cart.messageBox.sendKeys(PropertiesReader.getProperty("CRW014.message"));
		cart.addressChkoutBtn.click();

//		8.Webpage will navigate user to shipping details user can click on term of service and then click proceed to check out.
		cart.agreeChkbox.click();
		cart.shippingChkoutBtn.click();

//		9.Webpage will navigate user to  all details and payment about item : product,description,avail,unitprice,Qty and total.User click payment (pay by bank check).
		cart.payByBankWireBtn.click();

//		10.User will see all details about payment (pay by check) and then click "I confirm order".
		cart.iConfirmOrderBtn.click();

//		11.Webpage will be display "Your order on My Store is complete".
		Assert.assertEquals(cart.bankWireMsg.getText(),PropertiesReader.getProperty("CRW014.ordermsg"));
	}

	@AfterMethod
	public void afterTest() {
		Driver.tearDown();
	}
}
