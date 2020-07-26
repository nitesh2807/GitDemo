package com.sample.Learning_RestAssured.TestSetup;

import org.testng.annotations.Test;

import com.sample.Learning_Rest_Assured.TestSetup.TestSetup;

public class SampleTestCase extends TestSetup {

	
	@Test(groups= {"Regression","Sanity"})
	public void login()
	{
		System.out.println("Validate login Test case Executed");
	}
	@Test(groups= {"Sanity"})
	public void validatesignup(){
		System.out.println("Validate signup testcase executed");	}
		
	}

