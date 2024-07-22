package com.qa.opencart.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListners implements ITestListener {

	
	
	public void getReports() {
		String path=System.getProperty("user.dir")+"\\reports\\ExtentReports";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Automation Results");
		reporter.config().setDocumentTitle("Automation Test Results");
		
		
		ExtentReports extentReports=new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Automation Tester","Abhijit Ghosh");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println("Test Suite is started!!....");
		
		
		
	  }
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    // not implemented
	  }	  
	  @Override
	  public void onTestFailure(ITestResult result) {
	    // not implemented
	  }
	  
	  @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	 
	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }	  
	  @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	  
	  @Override
	  public void onStart(ITestContext context) {
		  System.out.println("Test Suite Started!!...");
	  }
	  
	  
	  @Override
	  public void onFinish(ITestContext context) {
	    System.out.println("Test Suite is ending!!...");
	    
	  }
	  

	
	
}
