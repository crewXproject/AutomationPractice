package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driver.Driver;
import utilities.PropertiesReader;
import utilities.commonMethods;

public class CRW013_signin  extends commonMethods{


	
	
		

		@BeforeTest
		public void OpenBrowser() {
		
			//1.  User open browser and navigate to http://automationpractice.com/index.php
					Driver.getDriver();
		}
		
		
		
		@Test (enabled=false)
		public void CRW013_Test1 () throws InterruptedException   {
			
			
			//2. Click on Sign in menu located on the top of homepage	
			comm.signinMenu.click();
			Assert.assertTrue(create.myaccountdisplay.isDisplayed());
			
			//3. In the Create an account section , User can enter an email in text box and then click Create an account button
			signin.createEmailInput.sendKeys(getFakeEmail());
			signin.createAccountBtn.click();
			Assert.assertTrue(create.PersonalInformationForm.isDisplayed());
			
			//4. User can see Create an account form, Now user should be able to fill in their information and then click Register button
			create.genderMr.click();
			create.firstnameinfoInput.sendKeys(PropertiesReader.getProperty("CRW131name"));
			create.lastnameinfoInput.sendKeys(PropertiesReader.getProperty("CRW131lastName"));
			create.passwordInputInfoPage.sendKeys(getFakePassword());
			
			create.selectdayOfBirth();
			Thread.sleep(2000);
			create.selectmonthsOfBirth();
			Thread.sleep(2000);
			create.selectyearsOfBirth();
			
			create.address.sendKeys(PropertiesReader.getProperty("CRW131Address"));
			create.city.sendKeys(PropertiesReader.getProperty("CRW031City"));
			create.selectstate();
			create.zipcode.sendKeys(PropertiesReader.getProperty("CRW131Zipcode"));
			create.mobilenumber.sendKeys(PropertiesReader.getProperty("CRW131StateMobilePhone"));
			
			// 5. Web page will navigate user to My ACCOUNT page that can manage 
			//	  all of your personal information and orders.
			create.Registerbut.click();
			Assert.assertTrue(create.myaccountdisplay.isDisplayed());	
			
		}
		
		
		@Test (enabled=false)
		public void CRW013_Test2 () throws InterruptedException   {
			
			
			// 2. Click on Sign in menu located on the top of homepage
			// 3. Web page must navigate to Authentication page 
			//	  which user can enter email and password to log in the web page
			comm.signinMenu.click();
			Assert.assertTrue(create.AuthenticationText.isDisplayed());
			
			// 4. In the Already Registered section, User can enter a valid email and password in text boxes and then 
			create.emailInputAlreadyRegis.sendKeys(PropertiesReader.getProperty("CRW131email"));
			create.passwordInputSignPage.sendKeys(PropertiesReader.getProperty("CRW131password"));
			
			// click Sign in button
			create.SignButt.click();
			
			// 5. Web page will navigate user to My ACCOUNT page that can manage all of your personal information and orders.
			Assert.assertTrue(create.WelcomeToYourAccountText.isDisplayed());
			
		}
		
		
		@Test (enabled=true)
		public void CRW013_Test3 () throws InterruptedException {
			
			 
			 // 2. Click on Sign in menu located on the top of homepage
			 // 3. Web page must navigate to Authentication page 
			 //	   which user can enter email and password to log in the web page
					comm.signinMenu.click();
					Assert.assertTrue(create.AuthenticationText.isDisplayed());

			 // 4. In the Already Registered section , User can enter a valid email and invalid password in text boxes and then 
					create.emailInputAlreadyRegis.sendKeys(PropertiesReader.getProperty("CRW131email"));
					create.passwordInputSignPage.sendKeys(getFakePassword());
					
			//      click Sign in button
					create.SignButt.click();
					
			 // 5. Web page should be displayed unauthorized message and user will not be able to log in the web page
					Assert.assertTrue(create.ErrorMssSigninPang.isDisplayed());	
					

			 
			
			
		}
		
		
		
	}
		
		



