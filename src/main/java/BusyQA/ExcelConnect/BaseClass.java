package BusyQA.ExcelConnect;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.CaptureScreenShot;
import Utilities.ConfigReader;

public class BaseClass {
	static public WebDriver driver;
	static public CaptureScreenShot screen;
	
	public static void init(String browsername, String Environment) throws IOException {
		if(browsername.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", ConfigReader.getValue("Chrome_Path"));
            driver = new ChromeDriver();
        }
		if(Environment.equalsIgnoreCase("QA")){

            driver.get(ConfigReader.getValue("QAUrl"));
        }

		driver.get(Environment);
		driver.manage().window().maximize();
	}
	
	
	public static void tearDown() {
		driver.close();
		
	}
	public String failed(String testname) throws IOException {
		screen = new CaptureScreenShot();
		String destination=screen.getScreenShot(driver, testname);
		return destination;
	}
}
