package SalesForce.Utilies;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	FileInputStream srcfile=null;
	
	public String GetProperty(String key) {
		String projectpath = System.getProperty("user.dir");
		String FilePath = projectpath+"/Application.properties";
		try {
			srcfile = new FileInputStream(FilePath);
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
