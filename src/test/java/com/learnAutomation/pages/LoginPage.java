package com.learnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
// https://freecrm.com
	WebDriver d;
	public LoginPage(WebDriver d) {

		this.d=d;
	PageFactory.initElements(d, this);	

	}

	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement login;

	@FindBy(xpath="//input[@name='email']")
	WebElement email;

	@FindBy(xpath="//input[@name='passwor']")
	WebElement password;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;

	public void loginToCRM(String username,String pass) throws InterruptedException {
		login.click();
		Thread.sleep(2000);
		email.sendKeys(username);
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(2000);
		loginbtn.click();

	}
}
