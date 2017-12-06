package parallelExecution.com.thinksys.parallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import Resources.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import pages1.IndexPage;
import pages1.LoginPage;
import pages1.MobilePage;
import pages1.MyAccountsPage;
import pages1.RegistrationPage;
import Factory1.Browserfactory;

public class Testbase {
	
	public WebDriver driver;
	utility utils;
	IndexPage Index;
	MobilePage Mobile;
	RegistrationPage Registration;
	MyAccountsPage MyAccount; 
	LoginPage login;
	
	public ExtentReports report;
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest logger;
	
   
	@BeforeSuite
	public void setup()
	{
		utils=new utility();
		report = new ExtentReports();
		 // Provide the Report Path
		 //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/myExtentReport.html");
		htmlReporter = new ExtentHtmlReporter("C:\\Eclipse\\com.thinksys.parallelExecution\\Reports\\myExtentReport.html");
		 report.attachReporter(htmlReporter);
		 report.setSystemInfo("Host Name", "Ashish-702HK");
		 report.setSystemInfo("Env", "Automation Testing");
		 report.setSystemInfo("User", "Ashish Mathur");
	}
	
	  @Parameters("browser")
	  @BeforeMethod
	  public void beforeTest(String browser) {

	  Browserfactory browserfactory=new Browserfactory(driver);
	  driver=browserfactory.getBrowser(browser);
	
	  Index=new IndexPage(driver);
	  Mobile=new MobilePage(driver);
	  Registration=new RegistrationPage(driver);
	  MyAccount=new MyAccountsPage(driver);
	  login=new LoginPage(driver);
	  }

	  @AfterMethod
	  public void teardownMethod(ITestResult result)
	 
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String path= utils.captureScreenshoot(driver, result.getName());
				//logger.log(LogStatus.FAIL,result.getName(), logger.addScreenCapture(path));
				
			}
			
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				String path=  utils.captureScreenshoot(driver, result.getName());
				//logger.log(LogStatus.FAIL,result.getName(), logger.addScreenCapture(path));
			}
			 driver.quit();
		}
	  
	/*  @AfterMethod
	  public void afterTest()
	  {
		  driver.quit();
	  }*/
	  
	  @AfterSuite
	  public void afterSuite()
	  {
		  
		  report.flush();
			
			
		  
	  }
}
