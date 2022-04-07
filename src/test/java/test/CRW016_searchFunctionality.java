package test;

import driver.Driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ListernersTestNG;
import utilities.PropertiesReader;
import utilities.commonMethods;

@Listeners(ListernersTestNG.class)
public class CRW016_searchFunctionality extends commonMethods{

	
	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver();
	}

	
	@Test(priority = 1)
    public void CRW016_verifySearch() {
//  1.1 In the center of page click into search field and type "printed dress".
        comm.searchInput.sendKeys("printed dress");
        comm.searchButton.click();
        
//	1.2 User sees images of printed dresses and their price listed on the website as a result.
	    List<WebElement> searchResult = driver.findElements(By.xpath("//span[@itemprop='price']"));
        System.out.println(searchResult.size());
      
        for(WebElement element : searchResult) {
          System.out.println(element.getText());
        }
      } 
	
	
	@Test(priority = 2)
	public void CRW016_verifySearchQTY() {
//  2.1 In the center of page click into search field and type "printed dress".
        comm.searchInput.sendKeys("printed dress");
        comm.searchButton.click();
		
//	2.2 Total number of searchable items (i.e. printed dresses) should be displayed on result grid.	
		List<WebElement> searchResult = dresses.dressSearch;
        System.out.println(searchResult.size());
        Assert.assertEquals(searchResult.size()+"", PropertiesReader.getProperty("CRW016.size"));
  
        for(WebElement element : searchResult) {
            System.out.println(element.getText());
            String Expected1 = element.getText().substring(0,7);
            Assert.assertEquals( Expected1, PropertiesReader.getProperty("CRW016.printed"));
            Assert.assertEquals(element.getText().substring(element.getText().indexOf('D')) , PropertiesReader.getProperty("CRW016.dress"));
        }
	}
	
	
	@Test(priority = 3)
    public void CRW016_notListedSearch() {
//	3.1 In the center of page click into search field and type "pants".
        comm.searchInput.sendKeys("pants");
        comm.searchButton.click();
        
//	3.2 There are no results as expected and there is a message that says "no results were found for your search "pants".
        List<WebElement> searchResult = driver.findElements(By.xpath("//a[contains(text(),'pants')][@itemprop='url']"));
                          
        if(searchResult.size()==0) {
        	        	
        	WebElement alertResult = driver.findElement(By.className("alert-warning"));
        	System.out.println(alertResult.getText());
        	Assert.assertEquals(alertResult.getText().split(" \"pants")[0], PropertiesReader.getProperty("CRW016.noresult"));        	
        }
    }
	
	
	@AfterMethod
	public void afterTest() {
		Driver.tearDown();
	}
}
