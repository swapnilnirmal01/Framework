package com.learnAutomation.pages;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnAutomation.Utility.BrowserFactory;
import com.learnAutomation.Utility.ExcelDataProvider;
import com.learnAutomation.Utility.Helper;
import com.learnAutomation.Utility.ReadConfiqFile;

public class BaseClass {
	
	public WebDriver d;
	public ExcelDataProvider excel;
	public ReadConfiqFile confiq;
	public ExtentReports extentreport;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupsuite() {
		excel=new ExcelDataProvider();
		confiq=new ReadConfiqFile();
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("C:\\Users\\hp\\eclipse-workspace\\Automation\\Reports\\sparkReport_"+Helper.getCurrentDateTime()+".html");
		extentreport=new ExtentReports();
		extentreport.attachReporter(sparkReporter);

	}
	
	@AfterSuite
	public void generateExtentReport() throws IOException {
		extentreport.flush();	
		
		}
	
	@BeforeClass
	public void setup()
	{
		d=BrowserFactory.startapplication(d,confiq.getBrowser(),confiq.getqaUrl());
	}
	
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(d);
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		Helper.captureScreenShot(d,result.getName());
		logger.fail("test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(d,result.getName())).build());
		}
	}
	

}
