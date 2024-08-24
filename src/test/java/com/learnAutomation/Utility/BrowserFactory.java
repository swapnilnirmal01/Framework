package com.learnAutomation.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	WebDriver d;
	public static WebDriver startapplication(WebDriver d,String browsername,String appurl) {
		
		if(browsername.equals("chrome")) 
		{
			 d=new ChromeDriver();
			 
		}
		else if(browsername.equals("firefox")) 
		{
			 d=new FirefoxDriver();
		}
		else 
		{
			System.out.println("does not support browser");
		}
		d.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		d.get(appurl);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			return d;
		
	}
	
	public static void quitBrowser(WebDriver d) {
		d.quit();
	}
}
