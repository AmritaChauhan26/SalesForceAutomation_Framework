package SalesForce.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	@FindBy (xpath ="//span[@class='pageDescription']/a[1]")
	WebElement datelink;
	
	@FindBy (xpath= "//div[@id='p:f:j_id25:j_id61:28:j_id64']")
	WebElement timelink;
	
	@FindBy (xpath ="//input[@id='evt5']")
	WebElement subject;
	
	@FindBy (xpath ="//img[@title='Subject Combo (New Window)']")
	WebElement newwindow;
	
	@FindBy (xpath ="//li[@class='listItem4']//a[1]")
	WebElement other;
	
	@FindBy (xpath ="//input[@id='EndDateTime_time']")
	WebElement endtime;
	
	@FindBy (id ="timePickerItem_42")
	WebElement nine;
	
	@FindBy (id ="timePickerItem_43")
	WebElement ninethirty;
	
	@FindBy (id ="timePickerItem_44")
	WebElement ten;
	
	@FindBy (id ="timePickerItem_45")
	WebElement tenthirty;
	
	@FindBy (id ="timePickerItem_46")
	WebElement eleven;
	
	@FindBy (id ="timePickerItem_47")
	WebElement eleventhirty;
	
	@FindBy (name="save")
	WebElement savetime;
	
	
	
	
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
	
	
	public void blockingAnEventinCalender() {
		WebDriverWait waitforelelement = new WebDriverWait(driver, 10);
		mywait(datelink,10);
		datelink.click();
		timelink.click();
		String mainwindow = driver.getWindowHandle();
		newwindow.click();
		
		waitforelelement.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Windows before switch: " + windows);
		System.out.println(driver.getTitle());
		for (String window:windows) {
			if(!mainwindow.equals(window)) {
				driver.switchTo().window(window);
				System.out.println("Switched to new window: " + driver.getTitle());
				// Perform action that closes the window
				other.click();	
				
				//Wait for popup to close
				waitforelelement.until(ExpectedConditions.numberOfWindowsToBe(1));
				 driver.switchTo().window(mainwindow);
				// Switch to the remaining open window
				/* Set<String> remaining = driver.getWindowHandles();
		            String remainingWindow = remaining.iterator().next();
		            driver.switchTo().window(remainingWindow);
		            
		            System.out.println("Switched back to: " + driver.getTitle());*/
				break;
		}
		}
		
		endtime.click();
	}
	
	public boolean timeDropDownVerification() {
		return nine.getText().trim().equals("9:00 PM")&&
		ninethirty.getText().trim().equals("9:30 PM")&&
		ten.getText().trim().equals("10:00 PM")&&
		tenthirty.getText().trim().equals("10:30 PM")&&
		eleven.getText().trim().equals("11:00 PM")&&
		eleventhirty.getText().trim().equals("11:30 PM");		   
		
	}
	
	public void timeSelection() {
		endtime.click();
		nine.click();
		savetime.click();
	}
}
	
