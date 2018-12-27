package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	//Creating Constructot with parameter 
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name= "uid")
	@CacheLookup
	WebElement Username;
	
	@FindBy(name= "password")
	@CacheLookup
	WebElement Userpassword;
	
	@FindBy(name= "btnLogin")
	@CacheLookup
	WebElement Login;
	
	@FindBy(xpath= "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogOut;
	
	
	public void setUsername(String uname){
		Username.sendKeys(uname);
	}
	public void setPassword(String pwd){
		Userpassword.sendKeys(pwd);
	}
	public void clickSubmit(){
		Login.click();

	
	}
	public void clickLogOut() {
		// TODO Auto-generated method stub
		lnkLogOut.click();
	}
   	}


