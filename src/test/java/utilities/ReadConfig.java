package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	//ReadConfig redcon=new ReadConfig();
	Properties properties;
	String path = "config.properties";

	// Default constructor
	public ReadConfig() throws Exception {

		properties=new Properties();
		FileInputStream fis=new FileInputStream(path);
		properties.load(fis);
	}
	
	//user defined method
	
	public String getBrowser() {  //firefox
		String value=properties.getProperty("browser");//firefox
		if(value!=null) {
		return value;
		}else {
			throw new RuntimeException("Browser is not found in config file");
		}
		
	}
}
