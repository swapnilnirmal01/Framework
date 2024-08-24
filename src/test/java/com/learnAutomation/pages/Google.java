package com.learnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.learnAutomation.Utility.Helper;

public class Google {
	
	// https://www.google.com
	WebDriver d;
	
	public Google(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d, this);
	}
	public void verify() {
		
		String actualTitle=d.getTitle();
		System.out.println("Title is : "+actualTitle);
		if(actualTitle.equals("google")) {
			System.out.println("Test pass");
		}
		else
		{
		Helper.captureScreenShot(d,actualTitle);
		}
	}

}
