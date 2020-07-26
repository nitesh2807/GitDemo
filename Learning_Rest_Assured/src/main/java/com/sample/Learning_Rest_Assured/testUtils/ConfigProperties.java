package com.sample.Learning_Rest_Assured.testUtils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
	"file:src\\test\\resources\\propertyfile\\config.properties"
})

public interface ConfigProperties extends Config  {
	@Key("baseURI")
	public String getBaseURI();
	@Key("basePath")
	public String getBasePath();
	@Key("createCustomerAPIEndPoint")
	public String getCreateCustomerAPIEndPoint();
	@Key("age")
	public int getAge();
	@Key("testDataSheetName")
	public String gettestDataSheetName();
	@Key("ValidAuthKey")
	public String getValidAuthKey();
	@Key("InValidAuthKey")
	public String getInValidAuthKey();
	@Key("updateCustomerAPIEndPoint")
	public String getupdateCustomerAPIEndPoint();
	@Key("deleteCustomerAPIEndPoint")
	public String getdeleteCustomerAPIEndPoint();
}
