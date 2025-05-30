package SalesForce.Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SalesForce.Base.Basepage;

public class UserMenuPage extends Basepage{

	public UserMenuPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy (id="userNavButton")
	WebElement Usermenu;
	
	@FindBy(xpath ="//a[text()='My Profile']")
	WebElement myprofile;
	
	@FindBy (xpath = "//a[text()='My Settings']")
	WebElement mysetting;
	
	@FindBy (xpath="//a[text()='Developer Console']")
	WebElement myconsole;
	
	@FindBy (xpath ="//a[text()='Switch to Lightning Experience']")
	WebElement switching;
	
	@FindBy (xpath="//a[text()='Logout']")
	WebElement Logout;
	
	@FindBy (id="PersonalInfo_font")
	WebElement personal;
	
	@FindBy (id="LoginHistory_font")
	WebElement loginhistory;
	
	@FindBy (id="DisplayAndLayout_font")
	WebElement displaylink;
	
	@FindBy (id="CustomizeTabs_font")
	WebElement customizelink;
	
	@FindBy (xpath="//select[@id='duel_select_0']")
	WebElement availabletab;
	
	@FindBy (xpath="//img[@title='Add']")
	WebElement add;
	
	@FindBy (xpath="//input[@title='Save']")
	WebElement save;
	
	@FindBy (xpath="//span[@id ='EmailSetup_font']")
	WebElement email;
	
	@FindBy (xpath="//a[@id='EmailSettings_font']")
	WebElement emailsetting;
	
	@FindBy (id="CalendarAndReminders_font")
	WebElement calender;
	
	@FindBy (xpath="//a[@id='Reminders_font']")
	WebElement reminder;
	
	@FindBy (xpath="//input[@id='testbtn']")
	WebElement testreminder;
	
	@FindBy(id="logo")
	WebElement logo;
	
	
	
	public void userDropdown() {
		waitClickable(Usermenu, 10);
		Usermenu.click();
		}
	public void logoutSalesForceApp() {
		Logout.click();
		
	}
	
	public boolean verifyUserMenuOptions() {
		
		return myprofile.getText().trim().equals("My Profile")&&
		mysetting.getText().trim().equals("My Settings")&&
		myconsole.getText().trim().equals("Developer Console")&&
		switching.getText().trim().equals("Switch to Lightning Experience")&&
		Logout.getText().trim().equals("Logout");
	}
	
	public void mySettingOptionClick() {
		mysetting.click();
		personal.click();
		loginhistory.click();
		displaylink.click();
		customizelink.click();	
		selectValuebyVisibleText("Profile");
		add.click();
		save.click();
		driver.navigate().refresh();
		email.click();
		emailsetting.click();
		calender.click();
		reminder.click();
		
		
	}
	
	public void selectValuebyVisibleText(String value) {
		Select tab = new Select(availabletab);
		tab.selectByVisibleText(value);
	}
	
		public boolean verifyPopUpWindow() {
			String mainwindow= driver.getWindowHandle();
			testreminder.click();
			WebDriverWait waitforelelement = new WebDriverWait(driver, 10);
			waitforelelement.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> allwindows= driver.getWindowHandles();
			for(String window:allwindows) {
				if(!mainwindow.equals(window)) {
					driver.switchTo().window(window);
					boolean title =driver.getTitle().contains("Reminders");
					driver.close();
					driver.switchTo().window(mainwindow);
					return title;
					}
			}
				return false;
	}
		
		public boolean developerConsoleWindow() {
			String mainwindow = driver.getWindowHandle();
			myconsole.click();
			
			WebDriverWait waitforelelement = new WebDriverWait(driver, 10);
			waitforelelement.until(ExpectedConditions.numberOfWindowsToBe(2));
			
			Set<String> allwindows = driver.getWindowHandles();
			for(String handle:allwindows) {
				if(!mainwindow.equals(handle)) {
					driver.switchTo().window(handle);
					driver.close();
					driver.switchTo().window(mainwindow);
					boolean title = driver.getTitle().contains("Salesforce - Developer Edition");
					return title;
				}
			}
			return false;	
		}
		
		public boolean logOutSalesForce() {
			Logout.click();
			waitClickable(logo, 10);
			boolean display=logo.isDisplayed();
			return display;
		}
			
}



