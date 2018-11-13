package Helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility {


     public static Boolean checkIfElementExistsWithXpath(WebDriver driverInstance, String Xpathlocator)
     {
         Boolean ElementFound = true;
       
         try 
         { 
        	 turnOffImplicitWaits(driverInstance);
        	 WebElement elementToBeFound = driverInstance.findElement(By.xpath(Xpathlocator)); 
         
         }
         catch (NoSuchElementException ex)
         {
             System.out.println(ex);
             ElementFound = false;
         }
         turnOnImplicitWaits(driverInstance);
         return ElementFound;
     }
     
     public static Boolean checkIfElementNotExistsWithXpath(WebDriver driverInstance, String Xpathlocator)
     {
         Boolean ElementFound = false;      
        try 
         { 
        	 turnOffImplicitWaits(driverInstance);
        	 WebElement elementToBeFound = driverInstance.findElement(By.xpath(Xpathlocator)); 
        	 
         }
         catch (NoSuchElementException ex)
         {
        	 System.out.println(ex);
             ElementFound = true;
         }
         turnOnImplicitWaits(driverInstance);
         return ElementFound;
     }

     public static Boolean checkIfElementExists(WebDriver driverInstance, WebElement elementDescription)
     {
         Boolean ElementFound = false;
         try
         {
             ElementFound = elementDescription.isDisplayed();
         }
         catch (ElementNotVisibleException ex)
         {
        	 System.out.println(ex);
             ElementFound = false;
         }
         catch (NoSuchElementException ex)
         {
        	 System.out.println(ex);
             ElementFound = false;
         }
         return ElementFound;
     }
  
     protected static void turnOffImplicitWaits(WebDriver DriverInstance) {
    	 DriverInstance.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	}

     protected static void turnOnImplicitWaits(WebDriver DriverInstance) {
    	DriverInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}


}
