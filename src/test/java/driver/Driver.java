package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import utilities.Constants;
import utilities.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class Driver {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {
			System.out.println(PropertiesReader.getProperty("browser"));
			switch (PropertiesReader.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			}

			System.out.println(PropertiesReader.getProperty("url"));
			driver.get(PropertiesReader.getProperty("url"));
			// maximize
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			PageInitializer.initialize();
		}
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}
