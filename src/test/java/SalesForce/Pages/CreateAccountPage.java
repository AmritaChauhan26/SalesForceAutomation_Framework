package SalesForce.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
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
	
	@FindBy (xpath="//select[@id='00NgK000011qRcY']")
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
	
	@FindBy (xpath="//a[text()='Merge Accounts']")
	WebElement mergeaccount;
	
	@FindBy(xpath="//input[@id='srch']")
	WebElement accountsearch;
	
	@FindBy(name="srchbutton")
	WebElement find;
	
	@FindBy (xpath="//input[@id='cid0']")
	WebElement checkbox1;
	
	@FindBy (xpath="//input[@id='cid1']")
	WebElement checkbox2;
	
	@FindBy (xpath="//input[@title='Next']")
	WebElement nextbtn;
	
	@FindBy(xpath="//div[@class='pbTopButtons']//input[@title='Merge']")
	WebElement mergebtn;
	
	@FindBy(xpath="//table[@class='list']//tr[2]/th/a")
	WebElement updatedacc;
	
	@FindBy (xpath="//a[normalize-space()='Accounts with last activity > 30 days']")
	WebElement lastactivity;
	
	@FindBy (id ="ext-gen149")
	WebElement ddbutton;
	
	@FindBy (xpath="//div[text()='Created Date']")
	WebElement datecreate;
	
	@FindBy (xpath="//input[@id='ext-comp-1042']")
	WebElement fromdate;
	
	@FindBy(xpath="//input[@id='ext-comp-1045']")
	WebElement todate;
	
	@FindBy(id ="ext-gen50")
	WebElement savebtn;
	
	@FindBy (id ="saveReportDlg_reportNameField")
	WebElement report;
	
	@FindBy (id="saveReportDlg_DeveloperName")
	WebElement report1;
	
	@FindBy (xpath="//table[@id='dlgSaveAndRun']//button[text()='Save and Run Report']")
	WebElement savenrun;
	
	@FindBy(id="buttonNever")
	WebElement neverbtn;
	
	@FindBy (xpath="//h1[@class='noSecondHeader pageType']")
	WebElement reporttitle;
	
	@FindBy (xpath="//a[contains(text(),'Edit')]")
	WebElement edit;
	
	@FindBy (name="fname")
	WebElement vname;
	
	@FindBy(id="fcol1")
	WebElement fielddd;
	
	@FindBy(id="fop1")
	WebElement operatordd;
	
	@FindBy(id="fval1")
	WebElement value;
	
	@FindBy (xpath="//select[@id='colselector_select_0']")
	WebElement availabletab;
	
	@FindBy (xpath="//a[@id='colselector_select_0_right']//img[@title='Add']")
	WebElement addbtn;
	
	@FindBy(name="save")
	WebElement savebtn1;
	
	@FindBy (xpath="//div[@title='Last Activity']")
	WebElement activitytab;
	
	@FindBy (name="fcf")
	WebElement viewdropdown1;
	
	
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
	
	public String mergeAccount()
	{
		mergeaccount.click();
		accountsearch.sendKeys("myaccount");
		mywait(accountsearch,10);
		find.click();
		checkbox1.click();
		checkbox2.click();
		nextbtn.click();
		mywait(mergebtn,10);
		mergebtn.click();
		driver.switchTo().alert().accept();	
		String actual=updatedacc.getText();
		return actual;
		
	}
	public void accountReport() {
		lastactivity.click();
		ddbutton.click();
		datecreate.click();
		fromdate.sendKeys("5/1/2025");
		todate.clear();
		todate.sendKeys("5/28/2025");
		savebtn.click();
		
	}
	
	public boolean reportTitle() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		savenrun.click();
		mywait(neverbtn,10);
		neverbtn.click();
		driver.switchTo().defaultContent();
		boolean actual =reporttitle.isDisplayed();	
		System.out.println("Report title visible: " + reporttitle.isDisplayed());

		return actual;
	}
	
	public void uniqueReportName() {
		Date time = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhss");
		String timestamp = dateformat.format(time);
		String uniquereport = "report"+timestamp;
		report.sendKeys(uniquereport);
		report1.click();	
	}
	
	public boolean editViewVerification() {
		waitClick(By.name("fcf"), 10);
		selectbyValue(viewdropdown,"00BgK0000065gLU");
		mywait(edit,10);
		edit.click();
		vname.clear();
		vname.sendKeys("My Accounts1");
		selectbyIndex(fielddd,1);
		selectbyValue(operatordd,"c");
		value.clear();
		value.sendKeys("a");
		//selectbyVisibleText(availabletab,"Last Activity");
		Select dropdown = new Select(availabletab);
		for (WebElement option : dropdown.getOptions()) {
		    System.out.println("Option text: " + option.getText());
		}

		addbtn.click();
		savebtn1.click();
		mywait(activitytab,10);
		boolean actual1= activitytab.isDisplayed();
		return actual1;
	}
	
	public boolean viewdropdownVerification() {
		Select viewdd1 = new Select(viewdropdown1);
		boolean actual2 =viewdd1.getFirstSelectedOption().isDisplayed();
		return actual2;
	}
}


