package SalesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SalesForce.Base.Basepage;

public class RandomScenarioPage extends Basepage {

	public RandomScenarioPage(WebDriver driver) {
		super(driver);
		}

	@FindBy (xpath ="//h1[@class='currentStatusUserName']")
	WebElement userlink;
}
