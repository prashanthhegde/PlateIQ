package Helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DriverWaitUtility {
	
	public static void waitForRequestsToComplete(WebDriver driverInstance) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driverInstance;
		long activeRequests = 2;
		if ((Boolean) js.executeScript("return window.jQuery != undefined")) {
			while (activeRequests != 0) {
				activeRequests = (Long) js.executeScript("return jQuery.active");
				System.out.println("Active Requests: " + activeRequests);
				Thread.sleep(3000);
			}
		}
	}
	
	public static void waitForPageLoad(WebDriver driverInstance) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driverInstance;
		Object documentState = 3;
		if ((Boolean) js.executeScript("return window.jQuery != undefined")) {
			while (!documentState.equals("complete")) {
				documentState = js.executeScript("return document.readyState");
				System.out.println("Active Requests: " + documentState);
				Thread.sleep(3000);
			}
		}
	}
	
	public static void waitForElementLoad(WebDriver driverInstance,WebElement elementtobe_visible) {
		
		WebDriverWait wait = new WebDriverWait(driverInstance, 7000);
		wait.until(ExpectedConditions.visibilityOf(elementtobe_visible));
		
	}
	
	
}
