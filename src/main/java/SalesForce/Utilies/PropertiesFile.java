package SalesForce.Utilies;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	FileInputStream srcfile=null;
	
	public String GetProperty(String key) {
		String filepath="/Users/amritachauhan2685/eclipseworkspace/SalesforceAutomation_Framework/Application.properties";
		
		try {
			srcfile = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(srcfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		return value;
	}

}
