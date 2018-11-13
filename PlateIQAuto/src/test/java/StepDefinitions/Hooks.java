package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;

import Helpers.ExtentManager;
import Helpers.ReadPropertyFile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Hooks {
	
	
	public static ExtentReports Extentreport;
	public static WebDriver driver;
	public static ExtentTest extenttestlog;
	
	@Before()
	public void openBrowser(Scenario scenario ) throws Exception {
		Extentreport=ExtentManager.getInstance();
		extenttestlog = Extentreport.createTest(scenario.getName());
		String browserName = ReadPropertyFile.ReadBrowserName();
		if(browserName.equals("Mozilla"))
			driver= new FirefoxDriver();
		else if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			}
		else if(browserName.equals("IE"))
			driver= new InternetExplorerDriver();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//infoLog("Opened Browser");
}
	
	
	@After
	public void closeBrowserAndEmbedScreenshot(Scenario scenario) {
			
			
			driver.quit();
			extenttestlog.log(Status.INFO,"Closing the browser");
			extenttestlog.log(Status.INFO,"End of scenario --"+scenario.getName());
			Extentreport.flush();
	}
}
