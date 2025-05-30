package SalesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SalesForce.Base.BaseTest;
import SalesForce.Pages.CreateOpyPage;
import SalesForce.Pages.LoginPage;
import SalesForce.Pages.RandomScenarioPage;
import SalesForce.Utilies.ScreenShot;

public class RandomScenarioTest extends BaseTest {
	
	WebDriver driver;
	LoginPage loginpage;
	CreateOpyPage createopy;
	ScreenShot screenshot;
	RandomScenarioPage random;
	
	@BeforeMethod
	 public void beforemethod() {
		driver = LaunchApplication();
		loginpage = new LoginPage(driver);
		createopy = new CreateOpyPage(driver);
		random =new RandomScenarioPage(driver);
		screenshot = new ScreenShot();
	}
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		closebrowser();
	}
	
	@Test
	public void userNameLinkVerification() {
		
	}

}
