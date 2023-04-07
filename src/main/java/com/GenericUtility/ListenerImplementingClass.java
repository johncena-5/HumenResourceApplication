package com.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementingClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+" testScript execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+" passed");
		Reporter.log(MethodName+" testscript execution success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String Fscript = result.getMethod().getMethodName();
		String fs = Fscript+ new JavaUtility().systemDate();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Java/FailedtestScript.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = dest.getAbsolutePath();
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, result.getThrowable());
		
		
//		 String  ScreenShot = new WebDriverUtility().getScreenshot(BaseClass.sdriver, result.getMethod().getMethodName());
//		//ExtentTest screenShot = test.addScreenCaptureFromBase64String(new WebDriverUtility().getScreenshot(BaseClass.sdriver));
//		test.addScreenCaptureFromPath(ScreenShot);
//		test.log(Status.FAIL, result.getThrowable());
//		Reporter.log("test execution faild");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+" skip");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("test execution skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtendReport/report.html");
		htmlreport.config().setDocumentTitle("TEST YANTRA");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("HOUSE RENTAL APPLICATION");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/House_Rental_Application/index.php");
		report.setSystemInfo("Reporter", "waris");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	

}
