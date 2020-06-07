package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BrowserSetUp {

	public static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "Browser","URL"})
	public void beforeClass(String Browser,String URL) {

		this.setBrowserProperty(Browser);
		this.launchBrowser(Browser);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	/*
	* This method is required to set the system property while executing the
	* scripts on local system. Parameters: Browser: Name of the browser.
	*/
	public void setBrowserProperty(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			String gc_path = "./drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", gc_path);
			
		} else if (Browser.equalsIgnoreCase("firefox")) {
			String ff_path = "./drivers/geckodriver.exe";
			System.setProperty("webdriver.chrome.driver", ff_path);
			
		} else if (Browser.equalsIgnoreCase("ie")) {
			String ie_path = "./drivers/iedriver.exe";
			System.setProperty("webdriver.chrome.driver", ie_path);
		
		}
	}

	/*
	* This method return the browser instance as per the parameter provided.
	* Parameters: Browser: Name of the browser.
	*/
	public WebDriver launchBrowser(String Browser) {

		if (Browser.equalsIgnoreCase("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(options);
			
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		} else if (Browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
			
		} else {
			driver = new ChromeDriver();
		
		}

	return driver;
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
	driver.close();
	}
}
