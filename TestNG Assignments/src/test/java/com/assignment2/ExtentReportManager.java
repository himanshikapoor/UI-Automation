package com.assignment2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	public static ExtentReports getReporterObject() {
		String path = System.getProperty("user.dir") + "//reports/ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); // for the UI of the report
		reporter.config().setReportName("Form Automation Results");
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setTheme(Theme.STANDARD);

		ExtentReports extentReports = new ExtentReports(); // to populate common information in the report
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Tester", "Himanshi Kapoor");
		return extentReports;
	}

	public static String getScreenshotPath(String testCaseName) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot tScreenshot = (TakesScreenshot) GenerateExtentReport.driver;
		File sourceFile = tScreenshot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\screenshots\\" + testCaseName + "_" + timeStamp;

		try {
			FileUtils.copyFile(sourceFile, new File(destinationPath));
		} catch (Exception e) {
			e.getMessage();
		}

		return destinationPath;
	}
}
