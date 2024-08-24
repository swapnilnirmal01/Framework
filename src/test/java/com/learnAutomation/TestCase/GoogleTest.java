package com.learnAutomation.TestCase;

import org.testng.annotations.Test;

import com.learnAutomation.pages.BaseClass;
import com.learnAutomation.pages.Google;

public class GoogleTest extends BaseClass{
	
	@Test
	public void test() {
		logger=extentreport.createTest("Open google");
		logger.info("verify google title");
		Google google=new Google(d);
		google.verify();
		logger.pass("test pass");
	}

}
