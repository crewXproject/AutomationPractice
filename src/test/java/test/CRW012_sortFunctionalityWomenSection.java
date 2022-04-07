package test;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.Driver;
import utilities.commonMethods;

import utilities.PropertiesReader;

public class CRW012_sortFunctionalityWomenSection extends commonMethods {

	@BeforeMethod()
	public void beforeMethod() {

		// 1. User open browser and navigate to http://automationpractice.com/index.php
		Driver.getDriver().get(PropertiesReader.getProperty("url"));
		
		// 2. Click on the tab WOMEN
		click(comm.womenMenu);

	}

	@Test(enabled=true)
	public void sortItemByAtoZ() {

		// 3. Scroll down the page slowly and you view see the sort by tab.
		// 4. Click on Sort by tab.
		// 5. Choose sort → Product Name: A-Z and click.

		Select select = new Select(women.selectSortBy);
		select.selectByVisibleText(women.sortByAtoZ);

		// 6. User should be able to view the product which is sort by Product Name: A-Z
		Driver.wait.until(ExpectedConditions.stalenessOf(women.productNameList.get(0)));
		women.verifyItemSortedAtoZ();

	}
	
	@Test(enabled=true)
	public void sortByPriceLowToHigh() throws InterruptedException {

		// 3.Scroll down the page slowly and you view see the sort by tab.
		// 4.Click on Sort by tab.		
		// 5.Choose sort → Price: Lowest First and click.
		
		Select select = new Select(women.selectSortBy);
		select.selectByVisibleText(women.sortByPriceLowestFirst);
		
		// 6. User should be able to view the product which is sort by Price: Lowest First.
		Driver.wait.until(ExpectedConditions.stalenessOf(women.productPriceList.get(0)));
		women.verifyItemSortedLowestFirst();
	}
	
	@Test(enabled=false)
	public void sortItemByZtoA() {

		// 3. Scroll down the page slowly and you view see the sort by tab.
		// 4. Click on Sort by tab.
		// 5.Choose sort →  Product Name: Z-A and click.

		Select select = new Select(women.selectSortBy);
		select.selectByVisibleText(women.sortByZtoA);

		// 6. User should be able to view the product which is sort by Product Name: A-Z
		Driver.wait.until(ExpectedConditions.stalenessOf(women.productNameList.get(0)));
		women.verifyItemSortedZtoA();

	}
	
	@Test(enabled=true)
	public void sortItemByInStock() {
		// 3.Scroll down the page slowly and you view see the sort by tab.
		// 4.Click on Sort by tab.		
		// 5.Choose sort → In stock and click.
		
		Select select = new Select(women.selectSortBy);
		select.selectByVisibleText(women.sortByInStock);
		
		// 6. User should be able to view the product which is sort by In stock.
		Driver.wait.until(ExpectedConditions.stalenessOf(women.productNameList.get(0)));
		//women.verifyItemSortedZtoA();
		
		women.verifyItemSortedInStock();
		
	} 
	
	@AfterTest(enabled=true)
	public void afterMethod() {
		Driver.tearDown();
	}
}
