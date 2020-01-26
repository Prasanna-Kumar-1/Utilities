package SearchElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Utility.Utility;

public class SearchElement {
	
	@Test
	public void checkBuses()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Work\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		 
		driver.manage().window().maximize();
		 
		driver.get("https://www.redbus.in/");
		 
		Utility.click(driver,By.xpath("//button[contains(@class,'fl button')]"));
		 
		}

}
