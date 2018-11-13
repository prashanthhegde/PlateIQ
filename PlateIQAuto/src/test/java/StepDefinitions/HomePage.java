package StepDefinitions;

import org.testng.AssertJUnit;
import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Helpers.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import Helpers.DriverWaitUtility;


public class HomePage extends GlobalStepDefinition {
	
	@Given("^I launch the PlateIQ application$")
	public void i_launch_the_plateiq_application() throws Throwable {
		
		InvokeDriver(ReadPropertyFile.ReadApplicationUrl());
		Report.log(Status.INFO, "Launching the application");
	 
	}
	
	@Then("^I verify the text as \"(.*?)\" in login page$")
	public void i_verify_the_text_as_in_loginpage(String arg1) throws Throwable {
		
	     
		 Thread.sleep(3000);
		 DriverWaitUtility.waitForRequestsToComplete(_driver);
		 AssertJUnit.assertEquals(arg1, poPageFactory.loginpage.VerifyLoginpage());
		 Report.log(Status.INFO, "Validating  the login page");
	}
	
	@And("^I Login inside application$")
	public void login(List<String> data) throws InterruptedException {
		
		Report.log(Status.INFO, "Loggin in to the application with Username--"+data.get(0)+"password--"+data.get(1));
		//System.out.println(data.get(0));
		//System.out.println(data.get(1));
		DriverWaitUtility.waitForRequestsToComplete(_driver);
		poPageFactory.loginpage.login(data.get(0),data.get(1));
	}
	
	
	
	

}
