package Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {

	
	public static String ReadApplicationUrl() throws Exception{
		
		File src = new File("./Data/URL.property");
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		
		prop.load(fis);
		return prop.getProperty("PlateIQTest");
		
		
	}
		

	public static String ReadBrowserName() throws Exception{
		File browserfile = new File("./Data/Browser.property");
		FileInputStream fis = new FileInputStream(browserfile);
		Properties prop = new Properties();
		
		
		prop.load(fis);
		return prop.getProperty("Browser");
		
	}
	
	
		
	}

