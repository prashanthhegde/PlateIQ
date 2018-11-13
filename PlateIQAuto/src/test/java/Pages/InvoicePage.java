package Pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.DriverWaitUtility;
import Helpers.Utility;

public class InvoicePage {
	
private WebDriver _driver;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/piq-root/div/piq-auth-login/div/mat-card/section[2]/div[1]/input")
	WebElement UserName;
	
	@FindBy(how= How.XPATH,using = "/html/body/piq-site-navbar/nav/section[2]/span[5]")
	WebElement Invoices;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"tab-item-29\"]/ng-switch/span")
	WebElement Needs_attention;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"tab-item-30\"]/ng-switch/span")
	WebElement Pendin_Export;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"tab-item-31\"]/ng-switch/span")
	WebElement Other_Documents;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"tab-item-32\"]/ng-switch/span")
	WebElement All_Documents;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"tab-content-29\"]//table/tbody/tr[1]/td[2]")
	WebElement Needs_attention_first_link;
	
	@FindBy(how= How.XPATH,using = "//*[@class=\"dropdown\"]")
	WebElement Needs_attention_more_drop_down;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"invoice-header\"]//a[contains(.,'Mark as Exported')]")
	WebElement Mark_as_exported;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"invoice-header\"]//a[contains(.,'Mark as not Exported')]")
	WebElement Mark_as_not_exported;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"invoice-header\"]//span[contains(.,'Exported')]")
	WebElement exported_sign;
	
	@FindBy(how= How.XPATH,using = "//*[@id=\"tab-content-32\"]//table/tbody/tr[1]/td[2]")
	WebElement all_doc_first_link;
	


	
	public InvoicePage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(driver, this);}
	
	
	public void clickinvoices() {
		
		DriverWaitUtility.waitForElementLoad(_driver,Invoices);
		Invoices.click();
		
	}
	
	
	
	public boolean validateinvoice(String Invoicename) throws Exception   {
		
		return Utility.checkIfElementExistsWithXpath(_driver,"//*//div//tr[contains(.,'" + Invoicename + "')]");
		
	}
	
	public void validateinvoicetabs(String tabsValidation) {
		
		String[] InvoiceTabNames = tabsValidation.split(",");
		
		
		for(int i=0;i<4;i++) {
			
			System.out.println("Validating-----"+InvoiceTabNames[i]);
			if(InvoiceTabNames[i].equals("Needs Attention")) {
				assertTrue(Utility.checkIfElementExists(_driver, Needs_attention));
				
			}
			else if(InvoiceTabNames[i].equals("Pending Export")) {
				assertTrue(Utility.checkIfElementExists(_driver, Pendin_Export));
				
			}
			else if(InvoiceTabNames[i].equals("Other Documents")) {
				assertTrue(Utility.checkIfElementExists(_driver, Other_Documents));
				
			}
			else if(InvoiceTabNames[i].equals("All Documents")) {
				assertTrue(Utility.checkIfElementExists(_driver, All_Documents));
			}
			else {
				
				assertFalse("This tab"+InvoiceTabNames[i] +" validation failed", true);
			}
			
		}
	}
	
	
	public void clickfirstlinkneedsattention() {
		System.out.println("clicking on first link of needs attention");
		Needs_attention_first_link.click();
	}
	
	
	public void verifyinvoicelink() {
		
		
		DriverWaitUtility.waitForElementLoad(_driver, Needs_attention_more_drop_down);
		if (Utility.checkIfElementExists(_driver,Needs_attention_more_drop_down)) {
			assertTrue(true);

		} else {
			assertFalse("More drop down was not shown", true);
		}

	}
	
	public void exportandverify() throws Exception {
		
		System.out.println("marking as exported & validating");
		
		Needs_attention_more_drop_down.click();
		DriverWaitUtility.waitForElementLoad(_driver,Mark_as_exported);
		Mark_as_exported.click();
		
		System.out.println("validating if the item is exported");
		DriverWaitUtility.waitForElementLoad(_driver,exported_sign);
		if (Utility.checkIfElementExists(_driver,exported_sign)) {
			assertTrue(true);

		} else {
			assertFalse("Exported sign  not shown", true);
		}
	
		
	}
	
	
	public void clickfirstlinkalldocument() {
		System.out.println("click on all documents tab");
		All_Documents.click();
		//DriverWaitUtility.waitForElementLoad(_driver,all_doc_first_link);
		System.out.println("Clicking on the first link in all documents");
		all_doc_first_link.click();
		
		
	}
	
	
public void notexportandverify() throws Exception {
		
		System.out.println("marking as  NOT exported & validating");
		
		Needs_attention_more_drop_down.click();
		DriverWaitUtility.waitForElementLoad(_driver,Mark_as_not_exported);
		Mark_as_not_exported.click();
		
		System.out.println("validating the absence of exported pil");
		DriverWaitUtility.waitForPageLoad(_driver);
		if (Utility.checkIfElementNotExistsWithXpath(_driver,"//*[@id=\"invoice-header\"]//a[contains(.,'Mark as not Exported')]")) {
			assertTrue(true);

		} else {
			assertFalse("Exported sign  not shown", true);
		}
	
		
	}
	
	
	
}
