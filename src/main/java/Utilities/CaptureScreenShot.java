package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenShot {

	String dest="";
	public String getScreenShot(WebDriver driver, String scenario_name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE); 
		SimpleDateFormat s=new SimpleDateFormat("yyy_MM_dd_hh_mm_ss");
		String d=s.format(new Date());
		dest=System.getProperty("user.dir")+"\\ScreenShots\\/"+d+"-"+scenario_name+".png";
		File destination=new File(dest);
		FileHandler.copy(source, destination);
		
		System.out.println("Screen shot has been taken");
		
		return dest;
	}
}
