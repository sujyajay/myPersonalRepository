package com.NewProjectFeb02.com;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import org.apache.commons.io.FileUtils;

@Listeners(TestListeners.class)
public class TC007_LaunchAndLogOn {

	public static WebDriver driver;
	
	@Test
	public void mainTest() throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/Batman/Desktop/Selenium/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://test.salesforce.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement loginID = driver.findElement(By.id("username"));
		WebElement passCode = driver.findElement(By.id("password"));
		WebElement loginbutton = driver.findElement(By.id("Login"));

		loginID.sendKeys("username");
		passCode.sendKeys("password");
		loginbutton.click();
		
		Thread.sleep(2500);
		//Assert.assertEquals(driver.getPageSource().contains("Please check your username and password. If you still can't log in, contact your Salesforce administrator."),true, "Log on failed.. ");
		
		//driver.close();
		
		//System.out.println(getScreenshot(driver));
		
		//mouseDoubleClick(driver, driver.findElement(By.id("")));
		
		driver.quit();
	}
	
	public String getScreenshot(WebDriver driver) throws IOException{

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./newFile.jpg");
		FileUtils.copyFile(source,dest);

		return System.getProperty("user.dir") + dest;
	}
	
	public void mouseDoubleClick(WebDriver driver, WebElement element){
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.doubleClick();
	}
}