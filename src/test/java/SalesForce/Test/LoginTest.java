package SalesForce.Test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Sales.Log.Log;
import SalesForce.Base.BaseTest;
import SalesForce.Pages.LoginPage;
import SalesForce.Utilies.ScreenShot;




public class LoginTest extends BaseTest{
	 WebDriver driver;
	 LoginPage loginpage;
	 ScreenShot screenshot;
	 
	 @BeforeMethod
	 
	 public void beforemethod() {
		 driver = LaunchApplication();
		 loginpage = new LoginPage(driver);
		 screenshot = new ScreenShot(); 
		 DOMConfigurator.configure("log4j.xml");
		 
		 }

	 @Test (priority=1)
	  
	 public void loginWithErrorMessage() {
		 Log.startTestCase("Login with error message - invalid login scenario");
		 loginpage.loginErrorMessage("chaamrita953@agentforce.com");
		 String actual = loginpage.getErrorMessageText();
		 String expected = "Please enter your password.";
		 Assert.assertEquals(actual, expected, "Login error is not displaying correctly.");
		 
	 }
	 
	 @Test(priority=2)
	 public void loginWithValidDetails() {
		 loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		 String actual = loginpage.getHomePageText();
		 String expectedresult = "Home";
		 Assert.assertEquals(actual, expectedresult, "Login failed or homepage not loaded.");
		  }
	 @Test(priority=3)
	 
	 public void rememberMeLogin() {
		 loginpage.RememberMe("chaamrita953@agentforce.com","Amrita@1985");
		 driver.get("https://login.salesforce.com");
		 boolean checkbox = loginpage.isRemembermeChecked();
		 String actual = loginpage.rememberUsername();
		 String expected ="chaamrita953@agentforce.com";
		 Assert.assertEquals(expected, actual, "User name not remembered");
		 Assert.assertTrue(checkbox, "Remember Checkbox should be selected");
	 }
	 
	 @Test(priority=4)
	 
	 public void forgotPassword() {
		 loginpage.forgotPasswordLink("chaamrita953@agentforce.com");
		 String actual= loginpage.forgotMessage();
		 String expected = "Check Your Email";
		 Assert.assertEquals(actual, expected,"Forgot password message not sent to user email ID");	 
	 }
	 
	 @Test(priority=5)
	 
	 public void loginWithInvalidDetails() {
		loginpage.invalidUsernamePassword("chaamrita953@agent","admin");
		String actual = loginpage.getErrorMessageText();
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(actual, expected,"Invalid credentials error message is not displayed");
		 
	 }
	 
	 @AfterMethod
	 
	 public void teardown() {
		 screenshot.takescreenshot(driver);
		 closebrowser();
		 
	 }

	}


