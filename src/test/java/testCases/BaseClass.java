package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig read=new ReadConfig();
	
	/*public String baseURL = "http://demo.guru99.com/v3/index.php";
	public String username = "mngr169244";
	public String password = "qUpYzAm";
	public static WebDriver driver;*/
	
	//Reading the ReadConfig file concept
	public String baseURL = read.getApplicationURL();
	public String username = read.getUsername();
	public String password =read.getPassword();
	public static WebDriver driver;
	
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup( String br){
		/*//System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", read.getChromePath());
		driver=new ChromeDriver();*/
		
		/*logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");*/
		
		if(br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", read.getfirefoxPath());
			driver=new FirefoxDriver();
			
		}
		else if(br.equals("ie")){
			System.setProperty("webdriver.ie.driver", read.getiePath());
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	public String captureScreenshot(WebDriver driver, String tname) throws IOException{
		//String dateName=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts= ((TakesScreenshot) driver);
	    File source = ts.getScreenshotAs(OutputType.FILE);
	   
	    File target = new File(System.getProperty("user.dir")+"/screenshots/"+ tname + ".png");
	 
	   // String destination=System.getProperty("user.dir")+ "/screenshots/" + tname + ".png";
		//File FinalDestination=new File(destination);
		Files.copy(source, target);
		System.out.println("Screenshot Taken");
		return tname;
		
		
		
	}
 
}
