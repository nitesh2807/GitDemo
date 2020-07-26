package com.sample.Learning_Rest_Assured.API;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.Learning_Rest_Assured.TestSetup.TestSetup;
import com.sample.Learning_Rest_Assured.testUtils.Data;
import com.sample.Learning_Rest_Assured.testUtils.TestUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ValidateCreateCustomerAPI extends TestSetup {
	
	
	@Test(dataProviderClass=Data.class,dataProvider="data")
	public void ValidateCreateCustomerAPIWithValidAuthKey(Hashtable<String,String> data) {
		testLevelLog.get().assignAuthor("Nitesh");
		
	
		
		Response response =CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		
		
		
	JsonPath responseJson=	response.jsonPath();
		Assert.assertEquals(response.statusCode(), data.get("ExpectedStatus"));	
		testLevelLog.get().info("responsecode is as expected");
		Assert.assertEquals(responseJson.get("email"), data.get("email"));
		testLevelLog.get().info("the email in response  is as per expected value");
		Assert.assertEquals(responseJson.get("description"), data.get("description"));
		testLevelLog.get().info("the description in response  is as per expected value");
		Assert.assertEquals(responseJson.get("name"), data.get("name"));
		testLevelLog.get().info("the name in response  is as per expected value");
		if(TestUtil.CheckJsonHasKey("id", response)) {
			Assert.assertNotNull(responseJson.get("id"));
		}else {
			Assert.fail("Id field is not available in the response" );
		}
	}
	

	@Test(dataProviderClass=Data.class,dataProvider="data")
	public void ValidateCreateCustomerAPIWithInValidAuthKey(Hashtable<String,String> data) {
		testLevelLog.get().assignAuthor("Nitesh");
		
	
		
		Response response =CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
		response.prettyPrint();
		TestUtil.logResponseInReport(response);
		
	JsonPath responseJson=	response.jsonPath();
		Assert.assertEquals(response.statusCode(), data.get("ExpectedStatus"));	
		testLevelLog.get().info("responsecode is as expected");
		Assert.assertFalse(TestUtil.CheckJsonHasKey("id", response));
		Assert.assertTrue(TestUtil.CheckJsonHasKey("error", response));
		
	}

}
