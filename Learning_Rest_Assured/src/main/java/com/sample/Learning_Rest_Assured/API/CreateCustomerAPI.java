package com.sample.Learning_Rest_Assured.API;
import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import com.sample.Learning_Rest_Assured.TestSetup.TestSetup;
import com.sample.Learning_Rest_Assured.testUtils.TestUtil;

import io.restassured.response.Response;

public class CreateCustomerAPI extends TestSetup {
	
	public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String, String> data){
		Response response=	given().auth().basic(configproperty.getValidAuthKey(), "").param("email",data.get("email")).
				param("description", data.get("description")).
				param("name", data.get("name")).post(configproperty.getCreateCustomerAPIEndPoint());
		
		TestUtil.logResponseInReport(response);
		return response;
		
	}

	public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String, String> data){
		Response response=	given().auth().basic(configproperty.getInValidAuthKey(), "").param("email",data.get("email")).
				param("description", data.get("description")).
				param("name", data.get("name")).post("customers");
		
		TestUtil.logResponseInReport(response);
		return response;
		
	}
}
