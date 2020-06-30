package com.opentext.bn.lens.cmd.utils;

import java.io.File;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opentext.bn.core.Config;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;


public class Report {

	
	public static ExtentTest test;

    public static ExtentReports report;



    /**

    *

     * This Method is to get the size for any listing using Tag Name.

    *

     * @param Response

    * @param tagname

    * @return

    */

    public int JsonCount(String Response, String tagname) {



                   JsonParser jsonParse = new JsonParser();

                   JsonObject jo1 = jsonParse.parse(Response).getAsJsonObject();

                   int size = jo1.get(tagname).getAsJsonArray().size();

                   return size;

    }

    @BeforeSuite

    public void setUp() {

                   Config.setTestMode();

                   Config.setCustomTestScriptName();

                   report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");

    }

    @AfterMethod

    public void getResult(ITestResult result) {

                   if (result.getStatus() == ITestResult.FAILURE) {

                                  // test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"

                                  // Test case FAILED due to below issues:", ExtentColor.RED));

                                  // test.fail(result.getThrowable());

                                  test.log(LogStatus.FAIL, "Test Failed");

                   } else if (result.getStatus() == ITestResult.SUCCESS) {

                                  test.log(LogStatus.PASS, result.getName() + "Test Case Passed");

                   }

    }

    @AfterSuite

    public static void endTest() {

                   report.endTest(test);

                   report.flush();

    }


}
