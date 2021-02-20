package BusyQA.ExcelConnect;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.LoginPage;
import PageClasses.LoginPage1;
import Utilities.CaptureScreenShot;
import Utilities.ConfigReader;

@Listeners(Utilities.ListenerUtil.class)
public class TC01_FailedLogin extends BaseClass{
	static String filepath="./Resources\\DataFiles\\";
	static ExcelReader excel;
	static CaptureScreenShot screen;
	LoginPage login;  //normal page object
	LoginPage1 login1; //page object with page factory concept
	
	@Parameters({"browser","env"})
	@BeforeTest
	public void Setup(String bname, String envname) throws IOException {
		// TODO Auto-generated method stub
		init(bname,envname);
		excel=new ExcelReader();
		screen=new CaptureScreenShot();
		login=new LoginPage(driver);
		login1=new LoginPage1(driver);
	}
	
	@Test
	public void TC01_FailedLoginTest() throws IOException {
	
	//driver.get(ConfigReader.getValue("QAUrl"));
	
	String name;
	String pass;
		
	ArrayList<String>data=new ArrayList<String>(); //{a,b,c,d,e}
	
	data=excel.getData(filepath, "loginData.xlsx", "login", 1);
	name=data.get(0);
	pass=data.get(1);
	
	String message=login1.checkInvLogin(name, pass);
	
	/*converting them into page object LoginPage
	driver.findElement(By.id("txtUsername")).sendKeys(name);
	driver.findElement(By.id("txtPassword")).sendKeys(pass);
	driver.findElement(By.id("btnLogin")).click();*/
	
	//String message =driver.findElement(By.id("spanMessage")).getText();
	
	screen.getScreenShot(driver, "TC01_FailedLoginTest");
	/*	if (message.equals("Invalid credentials")) {
		System.out.println("pass");
	}*/
	Assert.assertEquals(message, "Invalid credentials");
	
	excel.updateData(filepath, "loginData.xlsx", "login", 1, message);
	System.out.println("this is a test for Git changes");
	}
	@Test
	public void test2() {
		Assert.fail();
	}
	@AfterTest
	public void ClearAll() {
		tearDown();
	}
}
