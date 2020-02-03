package com.NewProjectFeb02.com;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TC017 {

	//Extent reports
	
	@Test
	public void extentReports(){
		
		System.out.println("This is start of EXTENT Reports");	
		
		ExtentHtmlReporter reporterPath = new ExtentHtmlReporter("./Reports/newExtentReport.html");	
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporterPath);
		ExtentTest logger = extent.createTest("LogonTest");
		logger.log(Status.INFO, "Log on success");
		
		extent.flush();		
	}	
}
