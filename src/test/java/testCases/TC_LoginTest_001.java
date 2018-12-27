package testCases;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException{
		
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank manager HomePage")) {
			Assert.assertTrue(true);
		    //Logger.info("login test passed");
			
		}
		else
		{
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
		}
		
		
	}
	

}
