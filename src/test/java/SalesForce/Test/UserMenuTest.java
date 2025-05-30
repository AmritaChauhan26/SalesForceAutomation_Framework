package SalesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SalesForce.Base.BaseTest;
import SalesForce.Pages.LoginPage;
import SalesForce.Pages.UserMenuPage;
import SalesForce.Utilies.ScreenShot;

public class UserMenuTest extends BaseTest{
	
	WebDriver driver;
	UserMenuPage usermenupage;
	LoginPage loginpage;
	ScreenShot screenshot;
	
	@BeforeMethod
	
	public void beforemethod() {
		driver = LaunchApplication();
		usermenupage = new UserMenuPage(driver);
		loginpage = new LoginPage(driver);
		screenshot = new ScreenShot();
		}
	
	@Test (priority=1)
	
	public void userDropDownList() {
		 loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		 usermenupage.userDropdown();
		 Assert.assertTrue(usermenupage.verifyUserMenuOptions(), "one or more user menu options are not displayed correctly");		   
	}
	
	@Test (priority=2)
	
	public void mySettingOption() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		 usermenupage.userDropdown();
		 usermenupage.mySettingOptionClick();
		 boolean result =usermenupage.verifyPopUpWindow();
		 Assert.assertTrue(result, "Pop Window did not close");	
	}
	
	@Test (priority=3)
	public void myConsoleDeveloperWindow() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		 usermenupage.userDropdown();
		 Assert.assertTrue(usermenupage.developerConsoleWindow(), "Console window did not close");
		}
	
	@Test (priority=4)
	public void logoutSalesForce() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		 usermenupage.userDropdown();
		 boolean result = usermenupage.logOutSalesForce();
		 Assert.assertTrue(result, "Logout is not working");
	}
	
	@AfterMethod
	
	public void teardown() {
		screenshot.takescreenshot(driver);
		 closebrowser();
		
	}

}
