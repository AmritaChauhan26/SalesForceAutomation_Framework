package SalesForce.Pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import SalesForce.Base.Basepage;

public class LeadsPage extends Basepage{

	public LeadsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath=" //a[@title ='Leads Tab']")
	WebElement leadtab;
	
	@FindBy (xpath="//h2[contains(text(), 'Home')]")
	WebElement leadhomepage;
	
	@FindBy (name="fcf")
	WebElement leadsdd;
	
	@FindBy (xpath="//input[@title='Go!']")
	WebElement gobutton;
	
	@FindBy (xpath="//input[@title='New']")
	WebElement newbutton;
	
	@FindBy (id="name_lastlea2")
	WebElement lastname;
	
	@FindBy (id="lea3")
	WebElement companyname;
	
	@FindBy (xpath="//input[@title='Save']")
	WebElement savebtn;
	
	@FindBy (xpath="//h1[@class='pageType']")
	WebElement heading;
	
	
	
	
	public void leadsHomePage() {
		waitClickable(leadtab,10);
		leadtab.click();
	}
	
	public String getleadpagetext() {
		return leadhomepage.getText();
	}
	
	public List<String> leadsDropdownVerify() {
		Select leaddropdown = new Select(leadsdd);
		List<WebElement> list =leaddropdown.getOptions();
		List <String> actual = new ArrayList<>();
		for(WebElement lists: list) {
			actual.add(lists.getText().trim());	
		}
		return  actual;	
	}
	
	public void selectLeadsDropdownoptions() {
		selectbyVisibleText(leadsdd,"All Open Leads");	
	}
	
	public String selectedOption() {
		Select leaddrop = new Select(leadsdd);
		String option=leaddrop.getFirstSelectedOption().getText();
		gobutton.click();
		return  option;
	}
	
	public String selectLeadsDropdownoption() {
		selectbyVisibleText(leadsdd,"My Unread Leads");
		//waitClickable(gobutton,10);
		//gobutton.click();
		Select lead = new Select(leadsdd);
		selectbyVisibleText(leadsdd,"My Unread Leads");
		String option=lead.getFirstSelectedOption().getText();
		return option;
		
	}
	
	public void newButtonClick() {
		mywait(newbutton,10);
		newbutton.click();
		mywait(lastname,10);
		lastname.sendKeys("ABCDE");
		companyname.sendKeys("ABCDE");
		savebtn.click();		
	}
	
	public String Heading() {
		String text=heading.getText();
		return text;
	}
	
	

}
