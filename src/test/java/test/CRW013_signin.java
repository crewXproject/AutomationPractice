package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.Driver;
import utilities.PropertiesReader;
import utilities.commonMethods;

@Test(groups = {"Smoke"})
public class CRW013_signin extends commonMethods {

    @BeforeMethod
    public void OpenBrowser() {
        //1.  User open browser and navigate to http://automationpractice.com/index.php
        Driver.getDriver();
    }

    @Test(enabled=true)
    public void CRW013_Test1() throws InterruptedException {
        //2. Click on Sign in menu located on the top of homepage        
    	click(comm.signinMenu);
    //	comm.signinMenu.click();
        Assert.assertTrue(create.myaccountdisplay.isDisplayed());

        //3. In the Create an account section , User can enter an email in text box and then click Create an account button
        sendText(signin.createEmailInput, getFakeEmail());
        //signin.createEmailInput.sendKeys(getFakeEmail());
       // signin.createAccountBtn.click();
        click(signin.createAccountBtn);
        Assert.assertTrue(create.PersonalInformationForm.isDisplayed());

        //4. User can see Create an account form, Now user should be able to fill in their information and then click Register button
        //create.genderMr.click();
        click(create.genderMr);
        sendText(create.firstnameinfoInput, PropertiesReader.getProperty("CRW131name"));
       // create.firstnameinfoInput.sendKeys(PropertiesReader.getProperty("CRW131name"));
        sendText(create.lastnameinfoInput, PropertiesReader.getProperty("CRW131lastName"));
        //create.lastnameinfoInput.sendKeys(PropertiesReader.getProperty("CRW131lastName"));
        sendText(create.passwordInputInfoPage, getFakePassword());
        //create.passwordInputInfoPage.sendKeys(getFakePassword());

        create.selectdayOfBirth();
        //Thread.sleep(2000);
        create.selectmonthsOfBirth();
       // Thread.sleep(2000);
        create.selectyearsOfBirth();
        
        sendText(create.address, PropertiesReader.getProperty("CRW131Address"));
        //create.address.sendKeys(PropertiesReader.getProperty("CRW131Address"));
        sendText(create.city, PropertiesReader.getProperty("CRW131City"));
        //create.city.sendKeys(PropertiesReader.getProperty("CRW131City"));
        create.selectstate();
        sendText(create.zipcode, PropertiesReader.getProperty("CRW131Zipcode"));
        //create.zipcode.sendKeys(PropertiesReader.getProperty("CRW131Zipcode"));
        sendText(create.mobilenumber, PropertiesReader.getProperty("CRW131StateMobilePhone"));
        //create.mobilenumber.sendKeys(PropertiesReader.getProperty("CRW131StateMobilePhone"));

        // 5. Web page will navigate user to My ACCOUNT page that can manage
        //	  all of your personal information and orders.
        create.Registerbut.click();
        Assert.assertTrue(create.myaccountdisplay.isDisplayed());
    }

    @Test(enabled = true)
    public void CRW013_Test2() throws InterruptedException {

        // 2. Click on Sign in menu located on the top of homepage
        // 3. Web page must navigate to Authentication page
        //	  which user can enter email and password to log in the web page
        click(comm.signinMenu);
    	//comm.signinMenu.click();
        Assert.assertTrue(create.AuthenticationText.isDisplayed());

        // 4. In the Already Registered section, User can enter a valid email and password in text boxes and then
        sendText(create.emailInputAlreadyRegis, PropertiesReader.getProperty("CRW131email"));
        //create.emailInputAlreadyRegis.sendKeys(PropertiesReader.getProperty("CRW131email"));
        sendText(create.passwordInputSignPage, PropertiesReader.getProperty("CRW131password"));
        //create.passwordInputSignPage.sendKeys(PropertiesReader.getProperty("CRW131password"));

        // click Sign in button
        click(create.SignButt);
        //create.SignButt.click();

        // 5. Web page will navigate user to My ACCOUNT page that can manage all of your personal information and orders.
        Assert.assertTrue(create.WelcomeToYourAccountText.isDisplayed());
    }

    @Test(enabled = true)
    public void CRW013_Test3() throws InterruptedException {

        // 2. Click on Sign in menu located on the top of homepage
        // 3. Web page must navigate to Authentication page
        //	   which user can enter email and password to log in the web page
        click(comm.signinMenu);
    	//comm.signinMenu.click();
        Assert.assertTrue(create.AuthenticationText.isDisplayed());

        // 4. In the Already Registered section , User can enter a valid email and invalid password in text boxes and then
        sendText(create.emailInputAlreadyRegis, PropertiesReader.getProperty("CRW131email"));
        //create.emailInputAlreadyRegis.sendKeys(PropertiesReader.getProperty("CRW131email"));
        sendText(create.passwordInputSignPage, getFakePassword());
        //create.passwordInputSignPage.sendKeys(getFakePassword());

        //      click Sign in button
        click(create.SignButt);
        //create.SignButt.click();

        // 5. Web page should be displayed unauthorized message and user will not be able to log in the web page
        Assert.assertTrue(create.ErrorMssSigninPang.isDisplayed());

    }

    @AfterMethod(enabled=true)
    public void afterMethod() {
        Driver.tearDown();
    }
}
		
		



