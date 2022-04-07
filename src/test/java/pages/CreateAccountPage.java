package pages;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;

	import driver.Driver;
	
	public class CreateAccountPage {
		 public CreateAccountPage() {PageFactory.initElements(Driver.getDriver(),this);}
		 @FindBy (xpath = "//*[@id=\"id_gender1\"]")
		 	public WebElement genderMr;
		 
		 @FindBy (xpath = "//*[@id=\"id_gender2\"]")
		 	public WebElement genderMrs;
		 
		 @FindBy(xpath="//*[@id=\"customer_firstname\"]")
		    public WebElement firstnameinfoInput;
		 
		 @FindBy (xpath = "//*[@id=\"customer_lastname\"]")
		 	public WebElement lastnameinfoInput;
		 
		 @FindBy (xpath = "//*[@id=\"email\"]")
		 	public WebElement emailInputAlreadyRegis;
		 
		 @FindBy (xpath = "//*[@id=\"passwd\"]")
		 	public WebElement passwordInputInfoPage;
		 
		 @FindBy (id = "days")
		 	public WebElement dayOfBirth;
		 
		 @FindBy (id = "months")
		 	public WebElement monthsOfBirth;
		 
		 @FindBy (id = "years")
		 	public WebElement yearsOfBirth;
		 
		@FindBy (xpath = "//*[@id=\"address1\"]")
			public WebElement address;

		@FindBy (xpath = "//*[@id=\"city\"]")
			public WebElement city;
		
		@FindBy (xpath = "//*[@id=\"id_state\"]")
			public WebElement state;
		
		@FindBy (xpath = "//*[@id=\"postcode\"]")
			public WebElement zipcode;
		
		@FindBy (xpath = "//*[@id=\"id_country\"]")
			public WebElement country;
		
		@FindBy (id = "phone_mobile")
			public WebElement mobilenumber;
		
		@FindBy (xpath = "//*[@id=\"submitAccount\"]/span")
			public WebElement Registerbut;
		
		
		 public void selectdayOfBirth() {
		        Select selected = new  Select(dayOfBirth);
		        selected.selectByValue("2");
		        
	}
		 public void selectmonthsOfBirth() {
		        Select selecte = new  Select(monthsOfBirth);
		        selecte.selectByValue("1");
	}
		
		 public void selectyearsOfBirth() {
		        Select sel = new  Select(yearsOfBirth);
		        sel.selectByValue("1960");
		 }
		 
		 public void selectstate() {
			 	Select selected = new  Select(state);
		        selected.selectByVisibleText("Virginia");
		 }

		 public void selectcountry() {
		        Select selected = new  Select(country);
		        selected.selectByValue("United");
		 }
		 

			@FindBy (xpath = "//*[@id=\"center_column\"]/h1")
				public WebElement myaccountdisplay ;
			
			@FindBy (xpath = "//*[@id=\"create-account_form\"]/h3")
				public WebElement CreateAnAccDisplay ;
			
			@FindBy (xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
				public WebElement PersonalInformationForm;
			
			@FindBy (xpath = "//*[@id=\"center_column\"]/h1")
				public WebElement AuthenticationText;
			
			@FindBy (id = "SubmitLogin")
				public WebElement SignButt ;
			
			@FindBy (id = "passwd")
				public WebElement passwordInputSignPage;
			
			@FindBy (xpath = "//*[@id=\"center_column\"]/p")
				public WebElement WelcomeToYourAccountText;
			
			@FindBy (xpath = "//*[@id=\"center_column\"]/div[1]/p")
				public WebElement ErrorMssSigninPang ;
		 
			//jaydalol
	}


