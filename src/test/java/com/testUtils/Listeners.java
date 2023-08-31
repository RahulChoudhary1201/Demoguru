package com.testUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.basesetup.BaseDriverSetup;
import com.utils.ExtentReportNG;

public class Listeners extends BaseDriverSetup implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReporter();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());

	}
	@Override
	public void onTestSuccess(ITestResult result) {

	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass()
					.getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),
					driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath,
				result.getMethod().getMethodName());

	}
	@Override
	public void onTestSkipped(ITestResult result) {
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}
	@Override
	public void onStart(ITestContext context) {
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
