package SalesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SalesForce.Base.BaseTest;
import SalesForce.Pages.CreateOpyPage;
import SalesForce.Pages.LeadsPage;
import SalesForce.Pages.LoginPage;
import SalesForce.Pages.RandomScenarioPage;
import SalesForce.Pages.UserMenuPage;
import SalesForce.Utilies.ScreenShot;

public class RandomScenarioTest extends BaseTest {
	
	WebDriver driver;
	LoginPage loginpage;
	CreateOpyPage createopy;
	UserMenuPage username;
	ScreenShot screenshot;
	LeadsPage leadspage;
	RandomScenarioPage random;
	
	@BeforeMethod
	 public void beforemethod() {
		driver = LaunchApplication();
		loginpage = new LoginPage(driver);
		username =new UserMenuPage(driver);
		createopy = new CreateOpyPage(driver);
		leadspage = new LeadsPage(driver);
		random =new RandomScenarioPage(driver);
		screenshot = new ScreenShot();
	}
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		closebrowser();
	}
	
	@Test(priority=1)
	public void userNameLinkVerification() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		String actual = random.usernameLink();
		String expected = "Amrita chauhan";
		Assert.assertEquals(actual, expected,"Invalid page is not displayed");
	}

	@Test(priority=2)
	public void lastnameEditUpdateVerification() {
		loginpage.loginWithValidCredentials("chaamrita491@agentforce.com","Amrita@1985");
		String actual1=random.lastnameEdit();
		String actual2= random.usernameDropDown();
		 Assert.assertTrue(actual1.contains("Chauhan"), "Top-left name is not updated.");
		 Assert.assertTrue(actual2.contains("Chauhan"), "Profile header name is not updated.");
	}
	
	@Test(priority=3)
	public void allAvailableTabsVerification() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		random.allAvailabletab();
		username.userDropdown();
		username.logoutSalesForceApp();
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		boolean tab =random.validateTabRemoved();
		Assert.assertFalse(tab, "Tab not removed ");
	}
	
	@Test (priority=4)
	public void calenderEventBlockValidation() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		random.blockingAnEventinCalender();
		Assert.assertTrue(random.timeDropDownVerification(), "Time is not displaying correctly");
		random.timeSelection();
	}
}
