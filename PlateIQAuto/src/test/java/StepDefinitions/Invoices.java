package StepDefinitions;

import org.junit.Assert;

import Helpers.DriverWaitUtility;
import Pages.POPageFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Invoices extends GlobalStepDefinition {

	@And("^I click on the invoices button$")
	public void click_on_the_invoices_button() throws Exception{
		
		DriverWaitUtility.waitForRequestsToComplete(_driver);
		poPageFactory.invoicepage.clickinvoices();
	}
	
	@Then("^verify the invoices (.*)$")
	public void validateTabs(String Invoicetabs) {
		poPageFactory.invoicepage.validateinvoicetabs(Invoicetabs);
		
	}
	
	@And("^User clicks on first links in needs attention$")
	public void validation_first_link_needs_attention() throws Exception{
		
		poPageFactory.invoicepage.clickfirstlinkneedsattention();
	}
	
	
	@Then("^verify if link is opened and More dropdown exists$")
	public void verfiylink() {
		poPageFactory.invoicepage.verifyinvoicelink();
		
	}
	
	@Then("^verify the following (.*) exist$")
	public void verify_the_invoicestab(String invoices) throws Throwable {
		
		DriverWaitUtility.waitForPageLoad(_driver);
		Assert.assertTrue(poPageFactory.invoicepage.validateinvoice(invoices));
	}
	
	@Then("^User clicks on mark as exported and validate exported text$")
	public void exportandverify() throws Exception {
		poPageFactory.invoicepage.exportandverify();
		
	}
	

	@And("^User clicks on first links in all documents$")
	public void validation_first_link_all_documents() throws Exception{
		
		poPageFactory.invoicepage.clickfirstlinkalldocument();
	}
	
	@Then("^User clicks on mark as  not exported and validate absence of exported status$")
	public void notexportandverify() throws Exception {
		poPageFactory.invoicepage.notexportandverify();
		
	}
}
