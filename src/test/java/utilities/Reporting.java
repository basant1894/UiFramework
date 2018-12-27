package utilities;

//This is a listener Class used to generate report
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public com.aventstack.extentreports.ExtentTest logger;


	public void onTestStart(ITestContext testContext){

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-"+timeStamp+".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");


		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/NewExtentReport.html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Basu-PC");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Basant");

		htmlReporter.config().setDocumentTitle("UiFramework Test Project");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr){
		logger = extent.createTest(tr.getName()); //Create New Entry in the report
		// Assert.assertTrue(true);
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	public void onTestfailure(ITestResult tr){
		logger = extent.createTest(tr.getName());
		//Assert.assertTrue(false);
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";

		File f = new File(screenshotPath);

		if(f.exists()){
			try{
				logger.fail("Screenshot is below :" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public void onTestSkipped(ITestResult tr){
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext){
		extent.flush();
	}
}


