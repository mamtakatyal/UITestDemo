package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties p=null;

	ConfigReader() throws IOException{
		p=new Properties();
		File file = new File(System.getProperty("user.dir")+"\\Resources\\ConfigFiles\\Env.properties");
		FileInputStream fis=new FileInputStream(file);
		p.load(fis);
	}
	public static String getValue(String key) throws IOException {
		
		if(p==null)
		{
			new ConfigReader();
		}
		return p.getProperty(key);
		
	}
}
