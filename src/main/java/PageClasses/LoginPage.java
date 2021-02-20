package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By name=By.id("txtUsername");
	By pass=By.id("txtPassword");
	By loginbtn=By.id("btnLogin");
	By message=By.id("spanMessage");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String checkInvLogin(String uname, String upass) {
		driver.findElement(name).sendKeys(uname);
		driver.findElement(pass).sendKeys(upass);
		driver.findElement(loginbtn).click();
		String msg=driver.findElement(message).getText();
		
		return msg;
		
		
	}
	
}
