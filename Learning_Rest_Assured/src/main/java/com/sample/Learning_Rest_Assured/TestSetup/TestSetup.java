package com.sample.Learning_Rest_Assured.TestSetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sample.Learning_Rest_Assured.testUtils.ConfigProperties;
import com.sample.Learning_Rest_Assured.testUtils.ExcelReader;
import com.sample.Learning_Rest_Assured.testUtils.ExtentManager;
import com.sample.Learning_Rest_Assured.testUtils.TestUtil;

import io.restassured.RestAssured;

public class TestSetup {

	public static ConfigProperties configproperty;
	public static ThreadLocal<ExtentTest> classLevelLog=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelLog=new ThreadLocal<ExtentTest>();
	
	
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\testdata\\TestDataSheet.xlsx");
	public static ExtentReports extentReport;
	@BeforeSuite
	public void setUpFramework() throws IOException {
		
		/*Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\java for Beginners\\Learning_Rest_Assured\\src\\test\\resources\\propertyfile\\config.properties");
		prop.load(fis);*/
		
		configproperty=ConfigFactory.create(ConfigProperties.class);
		/*RestAssured.baseURI=prop.getProperty("baseURI");
		RestAssured.basePath=prop.getProperty("basePath");*/
		/*RestAssured.baseURI="https://api.stripe.com/";
		RestAssured.basePath="v1/";*/
		
		TestUtil.archiveTestReport();
		RestAssured.baseURI=configproperty.getBaseURI();
		RestAssured.basePath=configproperty.getBasePath();
		
		extentReport = ExtentManager.GetExtent("F:\\java for Beginners\\Learning_Rest_Assured\\src\\test\\resources\\TestReport\\TestReport.HTML");
		
		//System.out.println(prop.getProperty("createCustomerAPIEndPoint"));
		/*System.out.println(configproperty.getCreateCustomerAPIEndPoint());
		System.out.println(configproperty.getAge());
		System.out.println(configproperty.gettestDataSheetName());*/
	}
	
	@BeforeMethod
	public void beforemethod(Method method) {
		System.out.println("Execution of TestCase---> "+method.getName()+"started");
		ExtentTest test = classLevelLog.get().createNode(method.getName());
		testLevelLog.set(test);
		testLevelLog.get().log(Status.INFO, "Extension of Test Case :- " +method.getName()+"started");
		
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before Class Executed");
		ExtentTest test  = extentReport.createTest(getClass().getSimpleName());
		classLevelLog.set(test);
		
	}
	@AfterMethod
	public void aftermethod(ITestResult testcaseresult) {
		System.out.println(" Execution of TestCase--------> "+testcaseresult.getName()+"Finished");
		
		testLevelLog.get().log(Status.INFO, " Execution of TestCase--------> "+testcaseresult.getName()+"Finished");
		
		if(testcaseresult.isSuccess()) {
			
			testLevelLog.get().pass("This Test Got Passed");
		}else {
			testLevelLog.get().fail("This test got Failed");
	
		}
	}
		@AfterSuite()
		public void teardownframework() {
			System.out.println(" After Suite Executed");
			extentReport.flush();
			
		}
	}
	

