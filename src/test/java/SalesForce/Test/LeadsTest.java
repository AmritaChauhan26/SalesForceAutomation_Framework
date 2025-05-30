package SalesForce.Test;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Sales.Log.Log;
import SalesForce.Base.BaseTest;
import SalesForce.Pages.LeadsPage;
import SalesForce.Pages.LoginPage;
import SalesForce.Pages.UserMenuPage;
import SalesForce.Utilies.ScreenShot;

public class LeadsTest extends BaseTest {
 
	WebDriver driver;
	LoginPage loginpage;
	LeadsPage leadspage;
	ScreenShot screenshot;
	UserMenuPage usermenupage;
	
	@BeforeMethod 
	public void beforemethod() {
		
		driver = LaunchApplication();
		loginpage = new LoginPage(driver);
		leadspage = new LeadsPage(driver);
		usermenupage = new UserMenuPage(driver);
		screenshot = new ScreenShot();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@AfterMethod
	
	public void teardown() {
		screenshot.takescreenshot(driver);
		 closebrowser();
		
	}
	
	@Test
	
	public void clickOnLeadsHomePage() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		leadspage.leadsHomePage();
		String actual=leadspage.getleadpagetext();
		String expected = "Home";
		Assert.assertEquals(actual, expected,"Leads home page not displayed");
	}
	
	@Test
	public void leadsDropDownOptions() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		leadspage.leadsHomePage();
		leadspage.leadsDropdownVerify();
		List<String>actual =leadspage.leadsDropdownVerify();
		List<String> expected = Arrays.asList("All Open Leads",
				  "My Unread Leads",
				  "Recently Viewed Leads",
				  "Today's Leads",
				  "View - Custom 1",
				  "View - Custom 2");
		Assert.assertEquals(actual, expected,"Dropddown menu did not match");
		
	}
	
	@Test
	public void leadsGoButton() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		leadspage.leadsHomePage();
		leadspage.selectLeadsDropdownoptions();
		usermenupage.userDropdown();
		usermenupage.logoutSalesForceApp();
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		leadspage.leadsHomePage();
		String actual =leadspage.selectedOption();
		String expected = "All Open Leads";
		Assert.assertEquals(actual, expected,"selected option is not selected in the dropdown");
		
	}
	
	@Test
	public void leadsSelectedOptionVisible() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		leadspage.leadsHomePage();
		Log.startTestCase("Click on the go button - to go on the next page");
		String actual =leadspage.selectLeadsDropdownoption();
		String expected = "My Unread Leads";
		Assert.assertEquals(actual, expected,"selected option is not selected in the dropdown");		
	}
	@Test
	public void leadsNewButton() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		leadspage.leadsHomePage();
		leadspage.newButtonClick();
		String actual =leadspage.Heading();
		String expected = "Lead";
		Assert.assertEquals(actual, expected,"Newly created page not displayed");
	}
	
	
}
