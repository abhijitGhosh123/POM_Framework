package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private By product_Header=By.cssSelector("div#content h1");
	private ElementUtil eleUtil;

	
	private By product_metadata=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By pricing_data=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");		
			

	
	
	private Map<String, String> productMap;
	
	public ProductInfoPage(WebDriver driver) {

		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}


	public String getProductHeader() {
		return eleUtil.doGetElementText(product_Header);
	}
	
	
	public void getProductMetaData() {
		List<WebElement> metaDataList=eleUtil.getElements(product_metadata);
		System.out.println("Product MetaData count: "+ metaDataList.size());
		
		productMap=new HashMap<String,String>();
		
		for(WebElement e:metaDataList) {
			String metaText= e.getText();
			String[] metaData=metaText.split(":");
			String metaKey=metaData[0].trim();
			String metaValue=metaData[1].trim();
			productMap.put(metaKey, metaValue);
		
		
		
		}
	}

}
