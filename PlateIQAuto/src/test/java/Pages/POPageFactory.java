package Pages;

import org.openqa.selenium.WebDriver;

public class POPageFactory {
	
	public final LoginPage loginpage;
	public final InvoicePage invoicepage;
	
	
	public POPageFactory(WebDriver driverInstance){
		
		loginpage = new LoginPage(driverInstance);
		invoicepage = new InvoicePage(driverInstance);
	}

}
