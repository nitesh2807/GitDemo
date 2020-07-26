package com.sample.Learning_Rest_Assured.testUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import com.sample.Learning_Rest_Assured.TestSetup.TestSetup;

import io.restassured.response.Response;

public class TestUtil extends TestSetup {
	
	public static boolean CheckJsonHasKey(String key,Response response) {
	JSONObject json = new JSONObject(response.asString());
	return json.has(key);
	}
	public static void logResponseInReport(Response response) {
		testLevelLog.get().info("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Click Here To See API Response"
				+ "</font>" + "</b >" + "</summary>" + response.asString() + "</details>"
				+ " \n");
		
	}
public static void archiveTestReport() {
		
		String reportName = "TestReport.html";

		String lastTestReportFilePath = "./src/test/resources/TestReport/TestReport.html";
		String archiveReportPath = System.getProperty("user.dir")+"/src/test/resources/ArchivedReport/";

		Date date = new Date();
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String formatedDate = dateFormate.format(date);
		String archiveTestReportName = formatedDate + "_" + reportName;

		File oldReport = new File(lastTestReportFilePath);

		File newFile = new File(archiveReportPath + archiveTestReportName);
		
		System.out.println(oldReport.exists());
		
		if (oldReport.exists()) {
			System.out.println("inside if");
			oldReport.renameTo(newFile);
			oldReport.delete();
		}
}
}
