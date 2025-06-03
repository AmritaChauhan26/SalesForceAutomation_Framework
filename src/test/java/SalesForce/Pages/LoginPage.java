package SalesForce.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import SalesForce.Base.Basepage;

public class LoginPage extends Basepage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id="username")
	WebElement UserName;
	
	@FindBy (id="password")
	WebElement Password;
	
	@FindBy (id ="Login")
	WebElement Login;
	
	@FindBy (id="error")
	WebElement error;
	
	@FindBy (id="rememberUn")
	WebElement Rememberme;
	
	@FindBy (xpath="//a[text()='Home']")
	WebElement Homepage;
	
	@FindBy (id="userNavButton")
	WebElement Usermenu;
	
	@FindBy (xpath="//a[text()='Logout']")
	WebElement Logout;
	
	@FindBy (id="forgot_password_link")
	WebElement Forgotpassword;
	
	@FindBy (id="un")
	WebElement fusername;
	
	@FindBy (id="continue")
	WebElement continuebtn;
	
	@FindBy (id="header")
	WebElement header;
	

	
	public void loginErrorMessage(String username) {
		UserName.sendKeys(username);
		Password.clear();
		mywait(Login,10);
		Login.click();
		}
	
	public String getErrorMessageText() 
	{	
		mywait(error,10);
	    return error.getText();
	    }
	
	
	public void loginWithValidCredentials(String username,String password) {
		mywait(UserName,10);
		UserName.sendKeys(username);
		Password.sendKeys(password);
		mywait(Login,10);
		Login.click();		
	}
	
public String getHomePageText() {
	mywait(Homepage,10);
    return Homepage.getText();
}

public void userDropdown() {
	Usermenu.click();
}
	
	public void RememberMe(String username, String password) {
		Rememberme.click();
		UserName.sendKeys(username);
		Password.sendKeys(password);
		mywait(Login,20);
		Login.click();
		waitClickable(Usermenu, 10);
		Usermenu.click();
		Logout.click();	
	}
	
	public String rememberUsername() {
		return UserName.getAttribute("value");
	}
	
	public boolean isRemembermeChecked() {
		return Rememberme.isSelected();
	}
	
	public void forgotPasswordLink(String username) {
		Forgotpassword.click();
		fusername.sendKeys(username);
		continuebtn.click();
	}
	
	public String forgotMessage() {
		
		return header.getText();
	}
	
	public void invalidUsernamePassword(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		mywait(Login,20);
		Login.click();
		
	}

	
	
	
	

}
