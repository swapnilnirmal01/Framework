package com.learnAutomation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiqFile {

	Properties prop;
	
	public ReadConfiqFile() {
		
		File src=new File("C:\\Users\\hp\\eclipse-workspace\\Automation\\Confiquration\\confiq.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
		System.out.println("Not able to load confiq file : "+e.getMessage());
	}
	}
	
	public String getDataFromConfiq(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getqaUrl() {
		return prop.getProperty("qaUrl");
	}
	
}

