package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public final class ProductInfoPageTest extends BaseTest{

	
	@BeforeClass
	public void productInfoPageSetup() {
	
		accountPage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim()
				);
	}
	
	
	
	@DataProvider
	public Object[][] getproductTestData() {
		
		return new Object[][] {
			{"MacBook","MacBook Pro"},
			{"MacBook","MacBook Air"},
			{"iMac","iMac"},
			{"Samsung","Samsung SyncMaster 941BW"},
			{"Apple","Apple Cinema 30\""}
			
			};
		
		
	}
	
	
	@Test(dataProvider = "getproductTestData")
	public void productHeaderTest(String search_key,String mainProductName) {
		productResultsPage=accountPage.performSearch(search_key);
		productInfoPage=productResultsPage.selectProduct(mainProductName);
		String actual_Productheader=productInfoPage.getProductHeader();
		Assert.assertEquals(actual_Productheader,mainProductName);
	
	
	}
	
	@Test
	public void productMetaDataTest() {
		productResultsPage=accountPage.performSearch("MacBook");
		productInfoPage=productResultsPage.selectProduct("MacBook Pro");
		productInfoPage.getProductMetaData();
		
	}
	
}
