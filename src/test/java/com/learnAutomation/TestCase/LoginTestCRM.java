package com.learnAutomation.TestCase;
import org.testng.annotations.Test;
import com.learnAutomation.Utility.BrowserFactory;
import com.learnAutomation.pages.BaseClass;
import com.learnAutomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass{

	@Test
	public void loginapp() throws InterruptedException {
		
		//logger=extentreport.createTest("Login to CRM");
		logger=extentreport.createTest("Login To CRM").assignAuthor("swapnil").
				assignCategory("functional testing");
		logger.info("Test Login to CRM");
		
      LoginPage lp=new LoginPage(d);
      
      logger.info("starting application");
      
      lp.loginToCRM(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1) );
      
      logger.pass("Login success");
   
      BrowserFactory.quitBrowser(d);
     
	}
}
