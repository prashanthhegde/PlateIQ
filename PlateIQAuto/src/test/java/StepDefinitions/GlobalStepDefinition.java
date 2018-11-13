package StepDefinitions;

import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Helpers.DriverWaitUtility;
import Helpers.ExtentManager;
import Pages.POPageFactory;

public class GlobalStepDefinition {
	
	public static  WebDriver _driver;
	public static ExtentTest Report;
	public static POPageFactory poPageFactory;
	
	
	
	public void InvokeDriver(String URL) throws InterruptedException {
		_driver = Hooks.driver;	
		 Report = Hooks.extenttestlog;
		//Report=ExtentManager.getInstance();
		 if (_driver != null)
	        {
			   	_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   // Setting implicit Timeout
	            _driver.manage().window().maximize();
	            _driver.get(URL);
	            poPageFactory = new POPageFactory(_driver);
	            DriverWaitUtility.waitForPageLoad(_driver);
	            
	        } 
		
	}

	
	public void close_browser() throws Throwable {
		
		_driver.quit();
		
	}
	
	
	

}
