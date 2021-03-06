package test;

import driver.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ListernersTestNG;
import utilities.PropertiesReader;
import utilities.commonMethods;

@Listeners(ListernersTestNG.class)
public class CRW099_Template extends commonMethods{

	@BeforeTest
	public void launchBrowser() {
		Driver.getDriver();
	}

	@Test
	public void CRW099_SigninWithValidUsername() {

		comm.signinMenu.click();
		signin.createEmailInput.sendKeys(PropertiesReader.getProperty("email"));
		signin.createAccountBtn.click();

		// for anyone who needs to use an email to REGISTER website in your test case
		// now you can use getFakeEmail() and also getFakePassword() method
		// to get new email every time when you run your test case

		String email = getFakeEmail();
		printMsg(email);
		printMsg(getFakePassword());

	}

	@Test
	public void CRW099_SigninWithInvalidUsername() {

		comm.signinMenu.click();
		signin.signinEmailInput.sendKeys(PropertiesReader.getProperty("email"));
		signin.createAccountBtn.click();


	}

	@AfterTest
	public void afterTest() {
		Driver.tearDown();
	}
}
