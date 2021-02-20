package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import BusyQA.ExcelConnect.BaseClass;

public class ListenerUtil extends BaseClass implements ITestListener{
	String destination;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
		try {
			destination=failed(result.getMethod().getMethodName());
			ExtentTestManager.getTest().addScreenCaptureFromPath(destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentTestManager.endTest();
	}

}
