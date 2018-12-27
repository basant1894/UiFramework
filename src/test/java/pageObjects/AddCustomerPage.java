package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	 
	public AddCustomerPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath= "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name= "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name= "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(name= "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name= "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(name= "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name= "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name= "pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(name= "telephoneno")
	@CacheLookup
	WebElement txtMobileNo;
	
	@FindBy(name= "emailid")
	@CacheLookup
	WebElement txtEmailId;
	
	@FindBy(name= "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name= "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer(){
		lnkAddNewCustomer.click();
	}
	public void custName(String cname){
		txtCustomerName.sendKeys(cname);
	}
	public void custGender(String cgender){
		rdGender.click();
	}
	public void custDOB(String mm, String dd, String yy){
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void custAddress(String caddress){
		txtaddress.sendKeys(caddress);
	}
	public void custCity(String ccity){
		txtCity.sendKeys(ccity);
	}
	public void custState(String cstate){
		txtState.sendKeys(cstate);
	}
	public void custPin(String cpin){
		txtPin.sendKeys(String.valueOf(cpin));
	}
	public void custMobile(String cmobile){
		txtMobileNo.sendKeys(cmobile);
	}
	public void custEmail(String cemail){
		txtEmailId.sendKeys(cemail);
	}
	public void custPassword(String cpwd){
		txtPassword.sendKeys(cpwd);
	}
	public void custSubmit(){
		btnSubmit.click();
	}





}
