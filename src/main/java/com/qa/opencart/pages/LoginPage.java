package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1.private By locators we have to maintain
	
	private By email_id=By.id("input-email");
	private By pwd=By.id("input-password");
	private By login_button=By.xpath("//input[@type='submit']");
	private By forgotPWD=By.linkText("Forgotten Password");

	
	//2.Constructors
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public String dogetTitle() {
		 return driver.getTitle();
	}
	
	public String dogetURL() {
		return driver.getCurrentUrl();
		
	}
	
	public boolean forgotpwdLinkExists() {
		return driver.findElement(forgotPWD).isDisplayed();
	}
	
	
	public AccountPage doLogin(String Username,String Password) {
		driver.findElement(email_id).sendKeys(Username);
		driver.findElement(pwd).sendKeys(Password);
		driver.findElement(login_button).click();
		
		return new AccountPage(driver);
	}
	
	
	
}
