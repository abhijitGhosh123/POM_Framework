package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.AppErrors;

public  final class AccountPageTest extends BaseTest{

	
	//@BeforeClass annotated method will run before any @test method 
	
	@BeforeClass
	public void accountSetup() {
		accountPage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@Test
	public void getAccountPageURL() {
		String accountURL=accountPage.dogetAccountPageURL();
		Assert.assertEquals(accountURL,AppConstants.ACCOUNT_PAGE_URL,AppErrors.NO_URL_MATCHED);
	}
	
	@Test
	public void getAccountPageTitle() {
		String accountPagetitle=accountPage.dogetAccountpageTitle();
		Assert.assertEquals(accountPagetitle,AppConstants.ACCOUNT_PAGE_TITLE,AppErrors.NO_TITLE_MATCHED);
	}
	
	
	@DataProvider
	public Object[][] getProductName() {
	 return	new Object[][]{
		 {"Macbook"},
		 {"imac"},
		 {"samsung"}
			
		};
	}
	
	
	@Test(dataProvider = "getProductName")
	public void productSearchTest(String product_name) {
		//String product_name="Mackbook";
		productResultsPage =accountPage.performSearch(product_name);
		String actualProductresultPage_title=productResultsPage.productresultPagetitle();
		System.out.println("Product Result page title is: "+actualProductresultPage_title);
		softAssert.assertEquals(actualProductresultPage_title,AppConstants.PRODUCT_PAGE_TITLE+" "+product_name);
		Assert.assertTrue(productResultsPage.dogetSearchedProductCount()>0);
	}

	
}
