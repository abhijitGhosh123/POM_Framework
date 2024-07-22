package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.ProductResultsPage;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory driverFactory;
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected ProductResultsPage productResultsPage;
	protected ProductInfoPage productInfoPage;
	protected SoftAssert softAssert;
	protected Properties prop;
	
	
	
	
	
	
	@BeforeTest
	public void setup() {
		
		driverFactory=new DriverFactory();
		prop=driverFactory.initProp();
		driver=driverFactory.initDriver(prop);
		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
