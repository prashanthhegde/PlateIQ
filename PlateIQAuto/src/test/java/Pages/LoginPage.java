package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Helpers.DriverWaitUtility;

public class LoginPage {
	
	private WebDriver _driver;
	
	
	@FindBy(how = How.NAME, using = "email")
	WebElement UserName;
	
	@FindBy(how= How.NAME,using = "passowrd")
	WebElement Password;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"login\"]/piq-root/div/piq-auth-login/div/mat-card/section[3]/piq-button-with-loading/button/span")
	WebElement Signin;
	
	
	@FindBy(how= How.CLASS_NAME,using = "plateiq-h1")
	WebElement LoginMessage;
	
	
	
	public LoginPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		Signin.click();
		
		
	}
	
	
	public String VerifyLoginpage() throws Exception{
		
		DriverWaitUtility.waitForRequestsToComplete(_driver);
		Thread.sleep(5000);
		String Text = LoginMessage.getText().toString();
		System.out.println("Login page actual text"+Text);
		return Text;
	}
	


}
