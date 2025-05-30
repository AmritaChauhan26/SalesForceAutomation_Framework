package SalesForce.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import SalesForce.Base.Basepage;

public class ContactsPage extends Basepage {

	public ContactsPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy (xpath="//a[normalize-space()='Contacts']")
	WebElement contactab;
	
	@FindBy (name="new")
	WebElement newbtn;
	
	@FindBy (id="name_lastcon2")
	WebElement lastname;
	
	@FindBy (id="con4")
	WebElement accountname;
	
	@FindBy (xpath="//td[@id='topButtonRow']//input[@title='Save']")
	WebElement savebtn;
	
	@FindBy (xpath="//h1[@class='pageType']")
	WebElement title;
	
	@FindBy (xpath ="//a[normalize-space()='Create New View']")
	WebElement createview;
	
	@FindBy (id="fname")
	WebElement viewname;
	
	@FindBy (id="devname")
	WebElement uniqueviewnamecontacts;	
	
	@FindBy (xpath="//td[@class='pbButtonb']//input[@value=' Save ']")
	WebElement viewsavebtn;
	
	@FindBy (name ="fcf")
	WebElement viewpagedd;
	
	@FindBy (id="hotlist_mode")
	WebElement recently;
	
	@FindBy (xpath= "//h3[normalize-space()='Recent Contacts']")
	WebElement recentcontact;
	
	@FindBy (xpath="//table[@class='list']/tbody/tr[2]/th/a")
	WebElement contactname;
	
	@FindBy (xpath="//h2[text()='Contact Detail']")
	WebElement contactdetails;
	
	@FindBy (xpath="//td[@class='pbButtonb']//input[@name='cancel']")
	WebElement cancelbutton;
	
	@FindBy (xpath="//h2[normalize-space()='Home']")
	WebElement homepage;
	
	@FindBy (xpath="//div[@class='errorMsg']")
	WebElement error;
	
	@FindBy(xpath ="//input[@name='save_new']")
	WebElement savennewbtn;
	
	@FindBy (xpath="//h2[normalize-space()='Contact Edit']")
	WebElement newcontactpage;
	
	public void contactTab() {
		waitClickable(contactab,10);
		contactab.click();	
	}
	
	public String createNewContact() {
		newbtn.click();
		lastname.sendKeys("Chauhan");
		accountname.sendKeys("Express Logistics and Transport");
		savebtn.click();
		mywait(title,10);
		String actual =title.getText();
		return actual;
	}
	
	public String createNewViewContacts() {
		createview.click();
		Date date = new Date();
		String timestamp = new SimpleDateFormat("yyyyMMddHHss").format(date);
		String uniqueviewname = "unique"+timestamp;
		viewname.sendKeys(uniqueviewname);
		uniqueviewnamecontacts.click();
		return uniqueviewname;		
	}
	
	public String dropdownSelectedView() {
		viewsavebtn.click();
		Select viewvalue = new Select(viewpagedd);
		String value =viewvalue.getFirstSelectedOption().getText();
		return value;
	}
	
	public String recentlyCreated() {
		selectbyVisibleText(recently,"Recently Created");
		String actual=recentcontact.getText();
		return actual;	
	}
	public String selectMyContacts() {
		selectbyVisibleText(viewpagedd,"My Contacts");
		Select viewvalue = new Select(viewpagedd);
		String value =viewvalue.getFirstSelectedOption().getText();
		return value;	
	}
	
	public boolean myContactLink() {
		contactname.click();
		boolean contacts = contactdetails.isDisplayed();
		return contacts;
	}
	
	public boolean uniqueViewnameEnterError() {
		createview.click();
		uniqueviewnamecontacts.sendKeys("efgh");
		viewsavebtn.click();
		boolean value=error.isDisplayed();
		return value;
		
	}
	
	public boolean cancelButtonClick() {
		createview.click();
		Date date = new Date();
		String timestamp = new SimpleDateFormat("yyyyMMddHHss").format(date);
		String uniqueviewname = "unique"+timestamp;
		viewname.sendKeys(uniqueviewname);
		uniqueviewnamecontacts.click();
		cancelbutton.click();
		boolean home =homepage.isDisplayed();
		return home;	
	}
	
	public boolean newAndSaveButtonContact() {
		newbtn.click();
		lastname.sendKeys("Chau");
		accountname.sendKeys("Global Media");
		savennewbtn.click();
		boolean value =newcontactpage.isDisplayed();
		return value;
		
	}

}
