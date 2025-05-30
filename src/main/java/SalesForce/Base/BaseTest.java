package SalesForce.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import SalesForce.Utilies.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	PropertiesFile property = new PropertiesFile();
	WebDriver driver;
	 
	public WebDriver LaunchApplication() {
		String browser = property.GetProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();	
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			driver.manage().window().maximize();
		}
		String url = property.GetProperty("url");
		driver.get(url);
		return driver;
			
	}
	
	public void closebrowser() {
		if(driver!=null) {
			driver.close();
			driver=null;
			
		}
	}

}
