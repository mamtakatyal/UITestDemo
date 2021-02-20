package BusyQA.ExcelConnect;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC02_SuccessLogin extends BaseClass{
	static String filepath="./Resources\\DataFiles\\";
	static ExcelReader excel;
	@BeforeTest
	public void Stepup() throws IOException {
		// TODO Auto-generated method stub
		init();
	}
@Test
public static void TC02_SuccessLoginTest() throws IOException {
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		String name;
		String pass;
		
		excel=new ExcelReader();
		ArrayList<String>data=new ArrayList<String>(); //{a,b,c,d,e}
		
		data=excel.getData(filepath, "loginData.xlsx", "login", 4);
		name=data.get(0);
		pass=data.get(1);
				
		driver.findElement(By.id("txtUsername")).sendKeys(name);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		
		
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Login Successful");
		//String message =driver.findElement(By.id("spanMessage")).getText();
		/*	if (message.equals("Invalid credentials")) {
			System.out.println("pass");
		}*/
		//Assert.assertEquals(message, "Invalid credentials");
}
@AfterTest
public void ClearAll() {
	tearDown();
}
}
