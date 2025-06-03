package SalesForce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SalesForce.Base.BaseTest;
import SalesForce.Pages.ContactsPage;
import SalesForce.Pages.CreateOpyPage;
import SalesForce.Pages.LoginPage;
import SalesForce.Utilies.ScreenShot;

public class ContactsTest extends BaseTest{
	
	WebDriver driver;
	LoginPage loginpage;
	CreateOpyPage createopy;
	ContactsPage contacts;
	ScreenShot screenshot;
	
	@BeforeMethod
	 public void beforemethod() {
		driver = LaunchApplication();
		loginpage = new LoginPage(driver);
		createopy = new CreateOpyPage(driver);
		contacts = new ContactsPage(driver);
		screenshot = new ScreenShot();
	}
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		closebrowser();
	}
	
	@Test
	public void createNewContantsValidation() {
		loginpage.loginWithValidCredentials("chaamrita491@agentforce.com","Amrita@1985");
		contacts.contactTab();
		String actual =contacts.createNewContact();
		String expected ="Contact";
		Assert.assertEquals(actual, expected,"New Contact is not created");
		
	}
	
	@Test
	
	public void createNewViewContact() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		contacts.contactTab();
		String actual = contacts.createNewViewContacts();
		String expected =contacts.dropdownSelectedView();
		Assert.assertEquals(actual, expected,"New view is not created");
	}
	
	@Test
	public void recentContactDisplay() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		contacts.contactTab();
		String actual=contacts.recentlyCreated();
		String expected = "Recent Contacts";
		Assert.assertEquals(actual, expected,"Recently created contacts are not created");	
	}
	
	@Test 
	public void myContactlink() {
		
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		contacts.contactTab();
		String actual = contacts.selectMyContacts();
		String expected = "My Contacts";
		Assert.assertEquals(actual, expected,"My contacts option is not selected");	
	}

	@Test 
	
	public void viewContactPage() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		contacts.contactTab();
		boolean result = contacts.myContactLink();
		Assert.assertTrue(result, "Contact details page is not displayed");		
	}
	
	@Test
	public void ViewErrorMessage() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		contacts.contactTab();
		boolean result = contacts.uniqueViewnameEnterError();
		Assert.assertTrue(result, "Error message is not displayed");		
	}
		
	
	@Test
	public void cancelButtonViewPage() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		contacts.contactTab();
		boolean result = contacts.cancelButtonClick();
		Assert.assertTrue(result, "Contact details page is not displayed");		
	}
	
	@Test
	public void saveAndNewClick() {
		loginpage.loginWithValidCredentials("chaamrita953@agentforce.com","Amrita@1985");
		contacts.contactTab();
		boolean result = contacts.newAndSaveButtonContact();
		Assert.assertTrue(result, "Contact details page is not displayed");		
		
	}
}
