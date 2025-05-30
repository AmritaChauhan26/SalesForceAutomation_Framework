package SalesForce.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import SalesForce.Base.Basepage;

public class CreateAccountPage extends Basepage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//a[text()='Accounts']")
	WebElement accounttab;
	
	@FindBy (xpath="//input[@title='New']")
	WebElement newaccount;
	
	@FindBy (xpath= "//input[@id='acc2']")
	WebElement accountname;
	
	@FindBy (xpath ="//select[@id='acc6']")
	WebElement typedropdown;
	
	@FindBy (xpath="//select[@id='00NgL00000tWa5X']")
	WebElement prioritydropdown;
	
	@FindBy (xpath= "//td[@id='topButtonRow']//input[@title='Save']")
	WebElement savebutton;
	
	@FindBy (xpath="//h1[@class='pageType']")
	WebElement saved;
	
	@FindBy (xpath ="//a[text()='Create New View']")
	WebElement view;
	
	@FindBy (xpath ="//input[@id='fname']")
	WebElement viewname;
	
	@FindBy (xpath ="//input[@id='devname']")
	WebElement uniquename;
	
	@FindBy (xpath ="//input[@data-uidsfdc='3']")
	WebElement savebt;
	
	@FindBy (name="fcf")
	WebElement viewdropdown;
	
	public void accountTab() {
		waitClickable(accounttab,10);
		accounttab.click();
	}
	
	public void newAccountCreation() {
		newaccount.click();
		accountname.sendKeys("myaccount");
		selectbyIndex(typedropdown, 6);
		selectbyIndex(prioritydropdown,1);
		savebutton.click();
	}
	public boolean newAccountValidation() {
		boolean display=saved.isDisplayed();
		return display;
	}
	
	public String uniqueViewName() {
		view.click();
		Date date = new Date();
		String timestamp = new SimpleDateFormat("yyyyMMddHHss").format(date);
		String uniqueviewname = "unique"+timestamp;
		viewname.sendKeys(uniqueviewname);
		uniquename.click();
		return uniqueviewname;
	}
	
	public String newViewCreation() {
		
		savebt.click();
		Select viewvalue = new Select(viewdropdown);
		String selectedoption = viewvalue.getFirstSelectedOption().getText();
		return selectedoption;
		
	}
}


