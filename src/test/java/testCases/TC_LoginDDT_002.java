package testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(uname);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true){
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			//logger.warn("Login Failed");
			
		}else{
			Assert.assertTrue(true);
			//logger.warn("Login Passed");
			lp.clickLogOut();
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
			
			
		}
	}
	//This is user defined method created to check Alert is present or not
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e){
		return false;
		
		
		
		}
	
	}
	//Data Provider method
	@DataProvider(name="LoginData")
    String [][]getData() throws IOException{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\testdta.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i <= rownum; i++){
			
			for(int j=0; j < colcount; j++){
				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1 0
				
			}
		}
		
		return logindata;
		
		
	}

}
