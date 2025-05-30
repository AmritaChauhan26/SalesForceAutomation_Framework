package SalesForce.Test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SalesForce.Base.BaseTest;
import SalesForce.Pages.CreateOpyPage;
import SalesForce.Pages.LoginPage;
import SalesForce.Utilies.ScreenShot;

public class CreateOpyTest extends BaseTest {
	

		WebDriver driver;
		LoginPage loginpage;
		CreateOpyPage createopy;
		ScreenShot screenshot;
		
		@BeforeMethod
		 public void beforemethod() {
			driver = LaunchApplication();
			loginpage = new LoginPage(driver);
			createopy = new CreateOpyPage(driver);
			screenshot = new ScreenShot();
		}
		
		@AfterMethod
		public void teardown() {
			screenshot.takescreenshot(driver);
			closebrowser();
		}
		@Test 
		public void opportunityDropDownList() {
			loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
			createopy.clickonOptyTab();
			List<String> actual = createopy.opportunityDropDownVerify();
			List<String> expected = Arrays.asList("All Opportunities",
													"Closing Next Month",
													"Closing This Month",
													"My Opportunities",
												    "New Last Week",
												    "New This Week",
												    "Opportunity Pipeline",
												    "Private",
												    "Recently Viewed Opportunities",
												    "Won");
			Assert.assertEquals(actual, expected,"Dropdown value is not matching");
			}
		@Test
		
		public void newOpportunityCreation() {
			loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
			createopy.clickonOptyTab();
			createopy.newOpptyVerification();
			String actual=createopy.Heading();
			String expected = "Opportunity";
			Assert.assertEquals(actual, expected,"New Opportunity page is not created");
		}
		
		@Test
		public void pipelineReportValidation() {
			loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
			createopy.clickonOptyTab();
			String actual =createopy.reportPipeline();
			String expected =  "Opportunity Pipeline";
			Assert.assertEquals(actual, expected,"Opportunity pipeline report is not created");
		}
		
		@Test
		public void stuckReportValidation() {
			loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
			createopy.clickonOptyTab();
			String actual =createopy.reportStuck();
			String expected =  "Stuck Opportunities";
			Assert.assertEquals(actual, expected,"Stuck Opportunity report is not created");
		}
		@Test
		
		public void quartlySummaryReportValidation() {
			loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
			createopy.clickonOptyTab();
			createopy.quartlySummaryReport();
			String actual = createopy.summaryverify();
			String expected= "Opportunity Report";
			Assert.assertEquals(actual, expected,"Stuck Opportunity report is not created");
			
			
		}
		
		
}
