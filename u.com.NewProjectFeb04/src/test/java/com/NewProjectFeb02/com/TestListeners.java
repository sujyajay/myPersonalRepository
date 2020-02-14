package com.NewProjectFeb02.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.Utils;

public class TestListeners extends TC007_LaunchAndLogOn implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("@Listener - test has just started");		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("@Listener - Test Successful");
		System.out.println();
		System.out.println("This is the driver variable : " + driver);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("@Listener - Test Fail");
		System.out.println();
		
		System.out.println("This is the driver variable : " + driver);
		
		System.out.println("This is the exception : " + result.getThrowable());
		
		//take screenshot
		try {
			System.out.println(getScreenshot(driver));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./newFile009.jpg");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("@Listener - Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("@Listener - Test start...P");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
}
