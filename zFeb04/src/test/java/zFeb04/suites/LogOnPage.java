package zFeb04.suites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogOnPage {

@Test

		public void sampleTest() {
		System.out.println("This is the start of the test");
		SoftAssert fail = new SoftAssert();		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Batman\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://test.salesforce.com/");
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("This is the end of the browser");
		
		try {
		boolean a = driver.findElement(By.id("a")).isDisplayed(); 
		
		System.out.println(a);
		}
		catch(NoSuchElementException e) {
			
			
			System.out.println("User: No Such element found. Please review");
		}
		
		driver.quit();
		
		fail.assertAll();		
		}
}