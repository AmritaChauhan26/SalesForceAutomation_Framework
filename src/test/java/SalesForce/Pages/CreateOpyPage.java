package SalesForce.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import SalesForce.Base.Basepage;

public class CreateOpyPage extends Basepage {

	public CreateOpyPage(WebDriver driver) {
		super(driver);
	}
		
		@FindBy (xpath ="//a[text()='Opportunities']")
		WebElement Opportunitytab;
		
		@FindBy(name="fcf")
		WebElement optydropdown;
		
		@FindBy (name="new")
		WebElement newbtn;
		
		@FindBy (name="opp3")
		WebElement optyname;
		
		@FindBy (xpath= "//input[@id='opp4']")
		WebElement accountname;
		
		@FindBy (xpath= "//input[@id='opp9']")
		WebElement date;
		
		@FindBy (xpath="//select[@id='opp11']")
		WebElement stagedd;
		
		@FindBy (xpath="//input[@id='opp12']")
		WebElement probablity;
		
		@FindBy (xpath="//select[@id='opp6']")
		WebElement leadsource;
		
		@FindBy (xpath="//td[@id='topButtonRow']//input[@title='Save']")
		WebElement savebtn;
		
		@FindBy (xpath="//h2[normalize-space()='Opportunity Detail']")
		WebElement NewOpty;
		
		@FindBy (xpath="//a[contains(text(),'Pipeline')]")
		WebElement pipeline;
		
		@FindBy (xpath="//h1[normalize-space()='Opportunity Pipeline']")
		WebElement report1;
		
		@FindBy (xpath="//a[text()='Stuck Opportunities']")
		WebElement stuck;
		
		@FindBy (xpath="//h1[normalize-space()='Stuck Opportunities']")
		WebElement report2;
		
		@FindBy (id="quarter_q")
		WebElement intervaldd;
		
		@FindBy (id="open")
		WebElement includedd;
		
		@FindBy (xpath="//input[@title ='Run Report']")
		WebElement savereport;
		
		@FindBy (xpath ="//h1[normalize-space()='Opportunity Report']")
		WebElement report3;
		
		
		
		public void clickonOptyTab(){
			waitClickable(Opportunitytab,10);
			Opportunitytab.click();
		}
		
		public List<String> opportunityDropDownVerify() {
			Select optydd = new Select(optydropdown);
			List<WebElement> options = optydd.getOptions();
			List<String> actual = new ArrayList<>();
			for(WebElement list: options) {
				actual.add(list.getText().trim());
			}
			return actual;	
		}
		
		public void newOpptyVerification() {
			newbtn.click();
			optyname.sendKeys("opportunity1");
			accountname.sendKeys("Burlington Textiles Corp of America");
			date.sendKeys("5/26/2025");
			selectbyVisibleText(stagedd,"Needs Analysis");
			probablity.clear();
			probablity.sendKeys("20");
			selectbyIndex(leadsource,3);
			savebtn.click();	
		}
		
		public String Heading() {
			String text=NewOpty.getText().trim();
			System.out.println(text);
			return text;
		}
		
		public String reportPipeline() {
			pipeline.click();
			String actual =report1.getText();
			return actual;
		}
		
		public String reportStuck() {
			stuck.click();
			String actual =report2.getText();
			return actual;	
		}
		public void quartlySummaryReport() {
			selectbyValue(intervaldd,"prev1");
			selectbyValue(includedd,"closed");
			savereport.click();	
		}
		
		public String summaryverify() {
			String actual =report3.getText();
			return actual;
		}

}
