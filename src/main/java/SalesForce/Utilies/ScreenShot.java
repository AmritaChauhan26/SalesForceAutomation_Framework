	package SalesForce.Utilies;
	
	import java.io.File;
	import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	
	public class ScreenShot {
	
		public void takescreenshot(WebDriver driver) {
			
			//TakeScreenshot object is created using the driver	
			TakesScreenshot screenshot1 = ((TakesScreenshot) driver);
			
			Date currentdate = new Date();
			String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-ss").format(currentdate);
			
			//Screenshot object have method getScreenshotAs
			//convert the Takescreenshot object to file object
			File scrFile = screenshot1.getScreenshotAs(OutputType.FILE);
			
			//Create the image format -png
			String projectpath = System.getProperty("user.dir");
			String filepath = projectpath+"/Screenshots/SalesForce"+timestamp+".png";
			
			//String filepath = "/Users/amritachauhan2685/eclipseworkspace/TestNGFrameWork/Screenshots/Teckarch"+timestamp+".png";
			File destfile = new File(filepath);
			
			try {
				FileUtils.copyFile(scrFile, destfile); //Using the FileUtil method copy the screenshot object to destination file object.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
