package com.learnAutomation.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	// screenshot , frames , Alert, windows, javascriptExecutor,sync issue

	static WebDriver d;
	public static String captureScreenShot(WebDriver d,String screenshotname) {
		
		String screenshot="C:\\Users\\hp\\eclipse-workspace\\Automation\\ScreenShots\\"+screenshotname+"_"+getCurrentDateTime() +".png";
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		
		File file=new File(screenshot);
		
		try {
			FileHandler.copy(src, file);
			System.out.println("captured screenshot");
		} catch (Exception e) {
		System.out.println("Unable to capture screenshot :"+e.getMessage());
		}
		return screenshot;
		
	}
	
	public static String getCurrentDateTime() {
		
		SimpleDateFormat customeformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDte=new Date();
		return customeformat.format(currentDte);
	}
	
	public void handleFrames() {
		
	}
	
	public void handleAlert() {
		
	}
	
	
	
}
