package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.AppErrors;

public  final class LoginpageTest extends BaseTest{

	@Test
	public void loginPageTitleTest() {
		String actual_Title=loginPage.dogetTitle();
		Assert.assertEquals(actual_Title,AppConstants.LOGIN_PAGE_TITLE,AppErrors.NO_TITLE_MATCHED);
	
	}
	
	@Test
	public void loginURLTest()
	{
		String actualURL=loginPage.dogetURL();
		Assert.assertEquals(actualURL,AppConstants.LOGIN_PAGE_URL,AppErrors.NO_URL_MATCHED);
	}
	
	@Test
	public void forgotpwdexistTest() {
		Assert.assertTrue(loginPage.forgotpwdLinkExists());
	}
	
	@Test
	public void loginTest() {
		 accountPage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		 Assert.assertTrue(accountPage.isLogoutLinkdisplayed(),AppErrors.LOGIN_UNSUCCESSFUL);
	}
}
