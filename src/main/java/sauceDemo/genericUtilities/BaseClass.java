package sauceDemo.genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import sauceDemo.objectRepository.InventoryPage;
import sauceDemo.objectRepository.LoginPage;

public class BaseClass {

	WebDriverUtility wU = new WebDriverUtility();
	JavaUtility jU = new JavaUtility();
	FileUtility fU = new FileUtility();
	public WebDriver driver = null;
	static WebDriver sDriver = null;

	@BeforeSuite
	public void beforeSuiteConfiguration() {

		System.out.println("===========Database Connection Established===========");

	}

	@BeforeClass
	public void beforeClassConfiguration() throws IOException {

		String BROWSER = fU.readDataFromPropertyFile("browser");
		String URL = fU.readDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else if (BROWSER.equalsIgnoreCase("ChromePrivate")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);

		} else {
			driver = new ChromeDriver();

		}

		// For Listener
		sDriver = driver;

		wU.maximizeWindow(driver);
		System.out.println("============" + BROWSER + " browser Launched==========");
		driver.get(URL);
		System.out.println("===========Navigated to URL==========");

	}

	@BeforeMethod
	public void beforeMethodConfiguration() throws IOException {

		String USERNAME = fU.readDataFromPropertyFile("username");
		String PASSWORD = fU.readDataFromPropertyFile("password");

		new LoginPage(driver).loginSauceDemo(USERNAME, PASSWORD);
		System.out.println("===========Successfully Logined==========");

	}

	@AfterMethod
	public void AfterMethodConfiguration() {

		new InventoryPage(driver).logout();
		System.out.println("===========Successfully Logged Out==========");

	}

	@AfterClass
	public void AfterClassConfiguration() {
		driver.quit();
		System.out.println("===========Browser Closed==========");

	}

	@AfterSuite
	public void AfterSuiteConfiguration() {

		System.out.println("===========Database Connection Closed===========");

	}

}
