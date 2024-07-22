package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppErrors;

public class AccountPage {

	private WebDriver driver;
	private By search=By.name("search");
	private By search_icon=By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");
	private By logout_link=By.linkText("Logout");
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
	}

	public String dogetAccountpageTitle() {
		return driver.getTitle();
		}
	
	public String dogetAccountPageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean isSearchbardisplayed() {
		return driver.findElement(search).isDisplayed();
	}
	
	public boolean isLogoutLinkdisplayed()
	{
		return driver.findElement(logout_link).isDisplayed();
		
	}

	public ProductResultsPage performSearch(String product_name) {
		System.out.println("Product that we want to search"+product_name);
		if(isSearchbardisplayed()) {
			WebElement search_bar=driver.findElement(search);
			search_bar.clear();
			search_bar.sendKeys(product_name);
			driver.findElement(search_icon).click();
			return new ProductResultsPage(driver);
		}
		else {
			return null;
		
	}
		
		
		
	}
	
}
