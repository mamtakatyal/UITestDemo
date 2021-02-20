package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	
	@FindBy(id="txtUsername")
	WebElement user;
	@FindBy(id="txtPassword")
	WebElement pass;
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	@FindBy(id="spanMessage")
	WebElement msg;
	
	public LoginPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);  //connects the driver instance with the current page object
	}
	
	public String checkInvLogin(String uname, String upass) {
		user.sendKeys(uname);
		pass.sendKeys(upass);
		loginbtn.click();
		String message= msg.getText();
		return message;
	}
	
}
