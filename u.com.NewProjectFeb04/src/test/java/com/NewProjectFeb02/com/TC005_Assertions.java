package com.NewProjectFeb02.com;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC005_Assertions {

	@BeforeTest
	public void preSetUp(){
		System.out.println("All preTest conditions will be taken care as part of this method");
	}
	
	
	@Test
	public void TC005_Assertions01(){
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(true, false, "This is an example of soft assertions");
		
		System.out.println("Soft assert has already failed but will be reported at the end.");
		
		sa.assertAll();
		Assert.assertEquals(true, false, "This is an example of hard assertions");
	}
	
}