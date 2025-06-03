package SalesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SalesForce.Base.BaseTest;
import SalesForce.Pages.CreateAccountPage;
import SalesForce.Pages.LoginPage;
import SalesForce.Utilies.ScreenShot;

public class CreateAccountTest extends BaseTest {
	
	WebDriver driver;
	LoginPage loginpage;
	CreateAccountPage createaccount;
	ScreenShot screenshot;
	
	@BeforeMethod
	 public void beforemethod() {
		driver = LaunchApplication();
		loginpage = new LoginPage(driver);
		createaccount = new CreateAccountPage(driver);
		screenshot = new ScreenShot();
	}
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		closebrowser();
	}
	
	@Test(priority=1)
	public void newAccountCreate() {
		loginpage.loginWithValidCredentials("chaamrita491@agentforce.com","Amrita@1985");
		createaccount.accountTab();
		createaccount.newAccountCreation();
		boolean actual = createaccount.newAccountValidation();
		Assert.assertTrue(actual,"New Account is not created properly");
	}
	
	@Test(priority=2)
	public void newAccountView() {
		loginpage.loginWithValidCredentials("chaamrita491@agentforce.com","Amrita@1985");
		createaccount.accountTab();
		String expected =createaccount.uniqueViewName();
		String actual = createaccount.newViewCreation();
		Assert.assertEquals(actual, expected,"Unique view name is not created");
	}
	
	@Test 
	public void editView() {
		loginpage.loginWithValidCredentials("chaamrita491@agentforce.com","Amrita@1985");
		createaccount.accountTab();
		boolean actual1= createaccount.editViewVerification();
		boolean actual2= createaccount.viewdropdownVerification();
		Assert.assertTrue(actual1&&actual2,"New Account is not created properly");
		
	}
	
	@Test (priority=4)
	public void mergeAccountVerification()
	{
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		createaccount.accountTab();
		String actual=createaccount.mergeAccount();
		String expected = "myaccount";
		Assert.assertEquals(actual, expected,"Accounts are not merged");
	
	}
	
	@Test (priority=5)
	public void reportVerification() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		createaccount.accountTab();
		createaccount.accountReport();
		createaccount.uniqueReportName();
		boolean actual =  createaccount.reportTitle();
		
		Assert.assertTrue(actual, "Report is not generated properly");
		
		
	}

}
