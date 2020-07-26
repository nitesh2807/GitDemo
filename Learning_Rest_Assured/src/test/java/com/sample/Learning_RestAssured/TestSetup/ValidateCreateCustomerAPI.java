package com.sample.Learning_RestAssured.TestSetup;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.Learning_Rest_Assured.API.CreateCustomerAPI;
import com.sample.Learning_Rest_Assured.TestSetup.TestSetup;
import com.sample.Learning_Rest_Assured.testUtils.Data;
import com.sample.Learning_Rest_Assured.testUtils.TestUtil;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class ValidateCreateCustomerAPI extends TestSetup {
	
	@Test(priority=0,dataProviderClass=Data.class,dataProvider="data")
	public void ValidateCreateCustomerAPIWithValidSecretKey(Hashtable<String , String> data) {
		
		RestAssured.baseURI="https://api.stripe.com/";
		RestAssured.basePath="v1/";
		
		testLevelLog.get().assignAuthor("Nitesh");
	/*Response response=	given().auth().basic("sk_test_XPdG2bBTjk6OfQv38U4TcPO9002BC3P7Am", "").param("email",data.get("email")).
		param("description", data.get("description")).
		param("name", data.get("name")).post("customers");*/
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		TestUtil.logResponseInReport(response);
		
		
	
	testLevelLog.get().info(response.asString());
	response.prettyPrint();
		try {
		Assert.assertEquals(response.statusCode(),200);
		testLevelLog.get().info("Response code matched: Expected :- 200 and Actual"+response.getStatusCode());
		}
		catch(Throwable e) {
			e.printStackTrace();
			testLevelLog.get().info("Response code not matched: Expected :- 200 and Actual"+response.getStatusCode());
		}
		JsonPath responseJson=response.jsonPath();
		System.out.println("Customer ID in Response ---> "+responseJson.get("id"));
		
		JSONObject json = new JSONObject(response.asString());
		//System.out.println(json.has("id"));
		Assert.assertTrue(json.has("id"));
		
		Assert.assertTrue(TestUtil.CheckJsonHasKey("id", response));
		testLevelLog.get().info(" Response contains ID field");
		
	}
	//@Test
	/*public void failTestCase()
	{
		Assert.fail();
	}*/
	
/*@Test(priority=1)
public void ValidateCreateCustomerAPIWithInValidSecretKey() {
		
		Response response=	given().auth().basic("sk_test_XPdG2bBTjk6OfQv38U4TcPO9002BC3P7An", "").param("email","awq@gmail.com").
			param("description", "hi").
			param("name", "qwrtty").post("https://api.stripe.com/v1/customers");
		
	 Assert.assertNotEquals(response.statusCode(),200 );
	 
	
		Assert.assertEquals(response.statusCode(), 401);
		
		
		Assert.assertFalse(TestUtil.CheckJsonHasKey("id", response));
	}*/

}
