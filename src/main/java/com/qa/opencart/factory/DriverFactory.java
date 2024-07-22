package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initDriver(Properties prop)
	{
		String browser_name=prop.getProperty("browser").trim();
		
		if(browser_name.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if(browser_name.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
		}
		else if(browser_name.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Enter correct browser value");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	public Properties initProp() {
	
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resource/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	
	
	}
	
}
