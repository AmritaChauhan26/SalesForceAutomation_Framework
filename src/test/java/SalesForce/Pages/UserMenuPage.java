package SalesForce.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy (xpath="//img[@title='Edit Profile']")
	WebElement Editprofile;
	
	@FindBy (xpath="//iframe[@id='contactInfoContentId']")
	WebElement iframe;
	
	@FindBy (xpath="//a[normalize-space()='About']")
	WebElement tab;
	
	@FindBy (xpath= "//input[@id='lastName']")
	WebElement lastname;
	
	@FindBy (xpath="//input[@value='Save All']")
	WebElement saveall;
	
	@FindBy (xpath="//span[text()='Post']")
	WebElement post;

	@FindBy (xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement iframe1;
	
	@FindBy (xpath="//body[@role='textbox']")
	WebElement textbox;
	
	@FindBy (xpath="//input[@id='publishersharebutton']")
	WebElement share;
	
	@FindBy(xpath="//span[text()='File']")
	WebElement filelink;
	
	@FindBy (id="chatterUploadFileAction")
	WebElement upload;
	
	@FindBy (id="chatterFile")
	WebElement fileupload;
	
	@FindBy(id="publishersharebutton")
	WebElement share1;
	
	@FindBy(id="photoSection")
	WebElement moderator;
	
	@FindBy (id="overlayBackground")
	WebElement overlay;
	
	@FindBy(id="uploadLink")
	WebElement uploadlink;
	
	@FindBy(id="uploadPhotoContentId")
	WebElement iframephoto;
	
	@FindBy (id="j_id0:uploadFileForm:uploadInputFile")
	WebElement choosebtn;
	
	@FindBy (xpath="//input[@id='j_id0:uploadFileForm:uploadBtn']")
	WebElement uploadimage;
	
	@FindBy (id="j_id0:j_id7:save")
	WebElement saveimage;
	
	@FindBy (xpath="//div[@id='photoSection']/span[2]/img[1]")
	WebElement photoicon;
	
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
		try{
			selectValuebyVisibleText("Profile");
			add.click();
		} catch(org.openqa.selenium.NoSuchElementException e)
		{
			e.printStackTrace();
		}
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
			
		public boolean myProfilePhotoupload() {
			myprofile.click();
			Editprofile.click();
			mywait(iframe,10);
			driver.switchTo().frame(iframe);
			tab.click();
			lastname.clear();
			lastname.sendKeys("Chauhan");
			saveall.click();
			driver.navigate().refresh();
			post.click();
			driver.switchTo().frame(iframe1);
			mywait(textbox,5);
			textbox.click();
			textbox.sendKeys("Hello First Post");
			driver.switchTo().defaultContent();
			share.click();
			Actions action = new Actions(driver);
			action.click(filelink).build().perform();
			upload.click();
			WebDriverWait waitforelement = new WebDriverWait(driver, 10);
			WebElement fileupload = waitforelement.until(ExpectedConditions.presenceOfElementLocated(By.id("chatterFile")));
			String filepath ="/Users/amritachauhan2685/Desktop/imagesfolder/Flowerimage.png";
			fileupload.sendKeys(filepath);
			share1.click();
			action.moveToElement(moderator).build().perform();
			waitforelement.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlayBackground")));
			waitforelement.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadLink")));
			waitforelement.until(ExpectedConditions.elementToBeClickable(uploadlink));
			uploadlink.click();
			driver.switchTo().frame(iframephoto);
			choosebtn.sendKeys("/Users/amritachauhan2685/Desktop/imagesfolder/imageupload.png");
			uploadimage.click();
			waitforelement.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_id0:j_id7:save")));
			saveimage.click();
			
			driver.navigate().refresh();
			waitforelement.until(ExpectedConditions.visibilityOf(photoicon));
			boolean expectedupload =  photoicon.isDisplayed();
			return expectedupload;
		
		}
}



