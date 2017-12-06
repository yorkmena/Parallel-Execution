package parallelExecution.com.thinksys.parallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages1.samplepage;

public class MultiBrowser extends Testbase{

			
		  // Once Before method is completed, Test method will start

		  @Test public void login() throws InterruptedException {

			  samplepage samplePage=new samplepage(driver);
			  
			  samplePage.clickButton();
			  samplePage.sendLog("testuser_1");
			  samplePage.sendPassword("Test@123");
			  samplePage.clickLogin();
			  
			  
			  
			/*driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		    driver.findElement(By.id("log")).sendKeys("testuser_1");

		    driver.findElement(By.id("pwd")).sendKeys("Test@123");

		    driver.findElement(By.id("login")).click();*/

			}  

		
	

}
