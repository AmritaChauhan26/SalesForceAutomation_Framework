package SalesForce.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForce.Base.Basepage;

public class RandomScenarioPage extends Basepage {

	public RandomScenarioPage(WebDriver driver) {
		super(driver);
		}

	@FindBy (xpath ="//h1[@class='currentStatusUserName']//a[@href='/_ui/core/userprofile/UserProfilePage']")
	WebElement userlink;
	
	@FindBy (id="tailBreadcrumbNode")
	WebElement nameheading;
	
	@FindBy (xpath ="//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement editbtn;
	
	@FindBy (xpath="//iframe[@id='contactInfoContentId']")
	WebElement iframe;
	
	@FindBy (xpath="//a[normalize-space()='About']")
	WebElement tab;
	
	@FindBy (xpath= "//input[@id='lastName']")
	WebElement lastname;
	
	@FindBy (xpath="//input[@value='Save All']")
	WebElement saveall;
	
	@FindBy (id="userNav")
	WebElement usernameupdate;
	
	@FindBy (xpath="//img[@class='allTabsArrow']")
	WebElement plustab;
	
	@FindBy (xpath ="//input[@title='Customize My Tabs']")
	WebElement customize;
	
	@FindBy (xpath="//select[@id='duel_select_0']")
	WebElement availabletab;
	
	@FindBy (xpath="//select[@id='duel_select_1']")
	WebElement selectedtab;
	
	@FindBy (xpath="//input[@title='Save']")
	WebElement savebtn;
	
	@FindBy (xpath ="//img[@title='Add']")
	WebElement addbtn;
	
	@FindBy (xpath="//img[@title='Remove']")
	WebElement removebtn;
	
	@FindBy (xpath ="//a[@title='Assets Tab']")
	List <WebElement> assetab;
	
	public String usernameLink() {
		mywait(userlink,10);
		userlink.click();
		mywait(nameheading,10);
		String name =nameheading.getText().trim();
		System.out.println(name);
		return name;
	}
	
	public String lastnameEdit() {
		mywait(userlink,10);
		userlink.click();
		editbtn.click();
		mywait(iframe,10);
		driver.switchTo().frame(iframe);
		tab.click();
		lastname.clear();
		lastname.sendKeys("Chauhan");
		saveall.click();
		 driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement namedisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='tailBreadcrumbNode']")));

		 String nametitle=namedisplay.getText();
		 
		return nametitle;
	}
	public String usernameDropDown() {
		waitClickable(usernameupdate, 10);
		usernameupdate.click();
		String username= usernameupdate.getAttribute("title");
		System.out.println("Username in dropdown: [" + username + "]");
		return username.trim();
	}
	
	public void allAvailabletab() {
		mywait(plustab,10);
		plustab.click();
		customize.click();
		try {	selectbyVisibleText(selectedtab ,"Assets");
			removebtn.click();
			
		} catch(org.openqa.selenium.NoSuchElementException e)
		{
			e.printStackTrace();
		}
		savebtn.click();	
	}
	
	public boolean validateTabRemoved() {
		return !assetab.isEmpty();
	}
	
}
