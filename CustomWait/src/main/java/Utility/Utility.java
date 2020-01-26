package Utility;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility {
	
	public static ExtentTest extentTest;
	
	//1. Created a wrapper method click() which automatically performs 
	//   a WebDriverWait, resulting in much stabler, better readable and maintainable scripts
	//
	//2. Also, added generic error handling as well. For example, StaleElement exception here
	//
	//3. Apart from this, additional functioanlity of logging is introduced
	
	public static void click(WebDriver driver, By by) 
	{
			try
			{
		    (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		    driver.findElement(by).click();
			}
			catch(StaleElementReferenceException sere) 
			{
		    	// simply retry finding the element in the refreshed DOM
		        driver.findElement(by).click();
			}
//			catch (TimeoutException toe) 
//			{
//				extentTest.log(LogStatus.ERROR, "Element identified by " + toe.toString() + " was not clickable after 10 seconds");
//		    }
	}
}
	

