package test;

import driver.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ListernersTestNG;
import utilities.PropertiesReader;
import utilities.commonMethods;

@Listeners(ListernersTestNG.class)
public class CRW014_PaymentFuctionality extends commonMethods{

	@BeforeTest
	public void launchBrowser() {
//		1.User open browser and navigate to http://automationpractice.com/index.php
		Driver.getDriver();
	}

	@Test
	public void CRW014_Test1() {
//		2.Click on sign in menu located on the top of homepage.
		comm.signinMenu.click();

//		3.User can enter email address and password and then click sign in to account.
		Assert.assertTrue(signin.signinEmailInput.isEnabled());
		signin.signinEmailInput.sendKeys(PropertiesReader.getProperty("CRW014.email"));
		signin.signinPasswdInput.sendKeys(PropertiesReader.getProperty("CRW014.password"));
		signin.signinBtn.click();

//		4.Webpage will navigate user to My Account.
		Assert.assertEquals(driver.getTitle(),PropertiesReader.getProperty("CRW014.myaccount"));

//		5.User can click "DRESS" button choose "EVENING DRESS" add item to the cart choose 1 Quantity and S size and choose Beige color and click add to the cart.
		Actions action = new Actions(driver);
		action.moveToElement(dresses.dressLink).build().perform();
		dresses.eveningDressesLink.click();
		dresses.printedDress.click();
		dresses.qtyInput("1");
		dresses.sizeDropdown("S");
		dresses.colorBox.click();
		Assert.assertTrue(dresses.addToCartBtn.isEnabled());
		dresses.addToCartBtn.click();
		dresses.checkoutBtn.click();

//		6.Webpage will navigate user to summary order and then user can click to proceed check out.
		cart.summaryChkoutBtn.click();

//		7.Next webpage will navigate user to delivery address and billing address details and user can update and comment all details and then click proceed to checkout.
		Assert.assertTrue(cart.updateBtn.isEnabled());
		cart.messageBox.sendKeys(PropertiesReader.getProperty("CRW014.message"));
		cart.addressChkoutBtn.click();

//		8.Webpage will navigate user to shipping details user can click on term of service and then click proceed to check out.
		cart.agreeChkbox.click();
		cart.shippingChkoutBtn.click();

//		9.Webpage will navigate user to  all details and payment about item : product,description,avail,unitprice,Qty and total.User click payment (pay by bank check).
		Assert.assertTrue(cart.productDesc.isDisplayed());
		cart.payByCheckBtn.click();

//		10.User will see all details about payment (pay by check) and then click "I confirm order".
		Assert.assertTrue(cart.checkPaymentDesc.isDisplayed());
		cart.iConfirmOrderBtn.click();

//		11.Webpage will be display "Your order on My Store is complete".
		Assert.assertEquals(cart.orderMsg.getText(),PropertiesReader.getProperty("CRW014.ordermsg"));

	}

	@AfterTest
	public void afterTest() {
		Driver.tearDown();
	}
}
