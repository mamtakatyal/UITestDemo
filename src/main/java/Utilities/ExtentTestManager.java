package Utilities;

import java.util.HashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	static HashMap<Integer, ExtentTest> extentTestMap=new HashMap<Integer, ExtentTest>();
	static ExtentReports report=ExtentManager.getInstance();
	static ExtentTest test;
	
	public static synchronized ExtentTest startTest(String testname) {
		test=report.createTest(testname);
		extentTestMap.put((int)Thread.currentThread().getId(), test);
		return test;
	}
	
	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int)Thread.currentThread().getId());
	}
	
	public static synchronized void endTest() {
		report.flush();
	}
}
