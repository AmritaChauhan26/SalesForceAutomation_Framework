package SalesForce.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	
	protected WebDriver driver;
	
	public Basepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public void mywait(WebElement element, int time) {
		WebDriverWait mywait = new WebDriverWait(driver,time);
		mywait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitClickable(WebElement element, int time) {
	    WebDriverWait wait = new WebDriverWait(driver, time);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitClickLocator(By locator, int time) {
	    WebDriverWait wait = new WebDriverWait(driver, time);
	    wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void selectbyVisibleText(WebElement value,String text) {
		Select select = new Select(value);
		select.selectByVisibleText(text);
	}

	public void selectbyValue(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectbyIndex(WebElement element,int value) {
		Select select = new Select(element);
		select.selectByIndex(value);
	}


}
