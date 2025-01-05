package com.onlinemart.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.onlinemart.extent.ExtentReporterER;
import com.onlinemart.utils.Utils;

    
    public class Listeners extends Utils implements ITestListener {
	
    ExtentTest test;
	ExtentReports extent= ExtentReporterER.getReportObject();

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
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
