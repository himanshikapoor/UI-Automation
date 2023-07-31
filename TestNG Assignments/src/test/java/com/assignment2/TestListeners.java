package com.assignment2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListeners implements ITestListener {
	ExtentReports extentReporter;
	ExtentTest test; // to create test entries

	@Override
	public void onStart(ITestContext context) {
		extentReporter = ExtentReportManager.getReporterObject();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extentReporter.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test has passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable().getMessage());

		try {
			String imgPath = ExtentReportManager.getScreenshotPath(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReporter.flush();
	}

}
