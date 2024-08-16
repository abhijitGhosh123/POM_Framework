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
		FileInputStream ip=null;
		
		
		String environemnt_Name=System.getProperty("env");
		System.out.println("Running tests on environemnt---->"+environemnt_Name);
		
		if(environemnt_Name==null) {
			System.out.println("No Environement is given,so runnning tests in QA environemnt!!...");
			try {
				ip=new FileInputStream("./src/test/resource/config/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			
			try {
			switch (environemnt_Name.toLowerCase()) {
			case "prod":
				ip=new FileInputStream("./src/test/resource/config/config.properties");
				break;
			
			case "qa": 
				ip=new FileInputStream("./src/test/resource/config/qaconfig.properties");
				break;
				
			case "uat":
				ip=new FileInputStream("./src/test/resource/config/uatconfig.properties");
				break;
				
				
			default:
				System.out.println("Please pass the correct environment");
				break;
			}
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		
		try {	
		prop.load(ip);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		}
		return prop;
		
	
	
	}
	
	}

