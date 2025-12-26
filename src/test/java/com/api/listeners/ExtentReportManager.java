package com.api.listeners;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class ExtentReportManager implements ITestListener {
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/ReqRes_Report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) { extent.flush(); }
}