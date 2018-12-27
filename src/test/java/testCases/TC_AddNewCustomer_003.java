package testCases;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


import net.bytebuddy.utility.RandomString;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		addcust.custName("Basant");
		addcust.custGender("male");
		addcust.custDOB("01", "08", "1994");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("Ranchi");
		addcust.custState("Jharkhand");
		addcust.custPin("822114");
		addcust.custMobile("8888877777");
		
		//Need unique or dynamic email 
		String email = randomstring()+"gmail.com";
		addcust.custEmail(email);
		addcust.custPassword("abcd");
		addcust.custSubmit();
		
		Thread.sleep(3000);
		
		//validation
		boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true){
			Assert.assertTrue(true);
		}
		else
		{
			
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	//this is for generating random string(i.e above need unique email id each time)
	public String randomstring(){
		String generatstring = RandomStringUtils.randomAlphabetic(8);
		
		return(generatstring);
	}
	//this is generate the number according to specific size
	public String randomNumber(){
		String generatstring2 = RandomStringUtils.randomNumeric(4);
		
		return(generatstring2);
	}

}
