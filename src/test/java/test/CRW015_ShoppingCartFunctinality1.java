package test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import driver.Driver;
import utilities.PropertiesReader;
import utilities.commonMethods;

public class CRW015_ShoppingCartFunctinality1 extends commonMethods{

	@BeforeMethod
	public void launchBrowser() {
//		1.1 Open browser and type URL http://automationpractice.com/
		Driver.getDriver();
	}

	@Test(priority = 1)
	public void CRW015_AddItem() {
//		1.2 Scroll down to find popular items on the homepage under the "POPULAR" label.
//		1.3 Add every item that is priced under $50.00 to the shopping cart by clicking the "Add to cart" button.

		List<WebElement> productResult = driver.findElements(By.xpath("//*[@id=\"homefeatured\"]/li/div/div[2]/div[1]"));
		int i = 1;
		int lastItem = productResult.size();
		String priceTag;

		for(WebElement element : productResult ) {
			
			priceTag = element.getText().substring(1,6);
			Double priceInt = Double.parseDouble(priceTag);
			if(priceInt <= 50) {
				System.out.println(priceInt);
				WebElement productImg = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[" + i +"]/div/div[1]/div/a[1]/img"));

				Actions actions = new Actions(driver);
				actions.moveToElement(productImg).build().perform();

				WebElement addtoCartBtn = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[" + i + "]/div/div[2]/div[2]/a[1]/span"));
				addtoCartBtn.click();

//		1.4 Click the "Continue shopping" button on the pop-up page to keep adding items with prices under $50 to the cart until all items under $50.00 are added to the shopping cart.
				
				WebElement continueShoping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
				System.out.println(i);
				if(lastItem-i == 0) {
					WebElement proceedChkout  = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
					proceedChkout.click();
				}else {
					continueShoping.click();
				}
			}
			i++;
		}

//		1.5 When finished adding all items with price under $50.00 to the shopping cart, click the "Proceed to checkout" button on the pop-up page to go to the cart.
		cart.proceedCheckoutBtn.click();
	}

	@Test(enabled = true)
	   public void CRW015_AddMoreItemandDeleteItem() throws InterruptedException {

//		2.1 Open browser and type URL http://automationpractice.com/
//		2.2 Scroll down to find popular items on the homepage under the "POPULAR" label.


//		2.3 Add the first item listed by clicking the "Add to cart" button.
		int i = 1;
		WebElement productImg = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[" + i +"]/div/div[1]/div/a[1]/img"));

		Actions actions = new Actions(driver);
		actions.moveToElement(productImg).build().perform();
		
		cart.addfirstItemBtn.click();
		Thread.sleep(3000);
		
//		2.4 Click the "Proceed to checkout" button on the pop-up page to go to the cart.
        cart.ProceedChkBtn.click();
        
//		2.5 Add a quantity of item in the cart by clicking on the "+" button in the "Qty" field one time. 
        cart.AddQtyUp.click();
        Thread.sleep(3000);
        
//		2.6 Users will see the additional quantity of items in the "Qty" field.
//		2.7 Subtract the quantity of item in the cart by clicking on the "-" button in the "Qty" field one time. 
//		2.8 Users will see the quantity of items in the "Qty" field has been subtracted.       
        cart.QtyDownBtn.click();

	}

	@Test(enabled = true)
	   public void CRW015_DeleteItem() throws InterruptedException {

//	    3.1 Open browser and type URL http://automationpractice.com/
//	    3.2 Scroll down to find popular items on the homepage under the "POPULAR" label.
		
//		3.3 Add the first item listed by clicking the "Add to cart" button.
		int i = 1;
		WebElement productImg = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[" + i +"]/div/div[1]/div/a[1]/img"));

		Actions actions = new Actions(driver);
		actions.moveToElement(productImg).build().perform();
		
		cart.addfirstItemBtn.click();
		Thread.sleep(3000);

//		3.4 Click the "Proceed to checkout" button on the pop-up page to go to the cart.
		cart.ProceedChkBtn.click();
		 Thread.sleep(3000);
		
//		3.5 Click the "Bin Icon" of the item in the cart to delete the item from the shopping cart.
        cart.DeleteItems.click();
	}

	@AfterMethod
	public void afterTest() {
		Driver.tearDown();


	}
}