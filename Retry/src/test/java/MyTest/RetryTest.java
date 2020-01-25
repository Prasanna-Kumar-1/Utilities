package MyTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RetryTest {
	
	public static WebDriver driver;
	
	   @BeforeTest
	   public void setup(){
	     System.setProperty("webdriver.gecko.driver","C:\\Work\\geckodriver.exe");
	       driver = new FirefoxDriver();
	       
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://www.google.com/");
	       
	       }
	   
//Writing retryAnalyzer like below is not a good approach. 
//If there are 100s of test cases, it is not a good approach to write the attribute for all the test cases
	   
//	   @Test(retryAnalyzer = Analyzer.RetryAnalyzer.class)
//	   public void test()
//	   {
//		   String Title = driver.getTitle();
//		   Assert.assertEquals("Google", "Googl");
//	   }
	   
//Better approach is to implement IRetryAnnotation. 
	   @Test
	   public void test()
	   {
		   String Title = driver.getTitle();
		   Assert.assertEquals("Googl", Title);
	   }
	   
	   
}
