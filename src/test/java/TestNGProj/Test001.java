package TestNGProj;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test001 {
	
	/*@BeforeSuite
	public void beforeSuiteReq() {
		System.out.println("this is before suite test in Test001");
	}
	
	@BeforeClass
	public void beforeClassReq() {
		System.out.println("this is before class test in Test001");
	}
	
	@BeforeMethod
	public void beforeMethodReq() {
		System.out.println("this is before method in Test001");
	}
	@BeforeTest
	public void beforeTestReq() {
		System.out.println("this is Before test in Test001");
	}
	@AfterSuite
	public void afterSuiteReq() {
		System.out.println("this is after suite test in Test001");
	}
	
	@AfterClass
	public void afterClassReq() {
		System.out.println("this is after class test in Test001");
	}
	
	@AfterMethod
	public void afterMethodReq() {
		System.out.println("this is after method test in Test001");
	}
	
	
	@AfterTest
	public void afterTestReq() {
		System.out.println("this is after test in Test001");
	}*/
	
	@Parameters({"user","pass"})
	@Test(alwaysRun=true, invocationCount=2) //this option will make sure that this method executes even if there is a failure in a method which stops its execution
	public void Test1(String name, String pass) {
		System.out.println("this is test1" + name + " "+ pass);
	}
	
	/*@Test(priority=0, dependsOnMethods="Test1") //setting the execution order and if required dependonmethods 
	public void Test2() {
		System.out.println("this is test2");
	}
	@Test(enabled=true, dependsOnMethods={"Test1","Test2"}) //deactivating or activating the method and multiple dependency example
	public void Test3() {
		System.out.println("this is test3");
	}*/
	
}
