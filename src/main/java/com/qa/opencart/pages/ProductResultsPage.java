package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

public class ProductResultsPage  {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By searched_products=By.xpath("//div[contains(@class,'product-layout product-grid')]");
	
	
	
	
	public ProductResultsPage(WebDriver driver) {
		this.driver=driver;
		 eleUtil=new ElementUtil(driver); 
		
	}
	
	public String productresultPagetitle() {
		return driver.getTitle();
	}
	
	public int dogetSearchedProductCount() {
		return   eleUtil.waitForElementsVisible(searched_products, TimeUtil.DEFAULT_TIME_OUT).size();
	}
	
	
	public ProductInfoPage selectProduct(String mainproductName) {
		System.out.println("Product name is: "+ mainproductName);
		//eleUtil.waitForElementsVisible(By.linkText(mainproductName),TimeUtil.DEFAULT_TIME_OUT);
		eleUtil.doClick(By.linkText(mainproductName));
		return new ProductInfoPage(driver);
		
	}
	
	
	
	
}
