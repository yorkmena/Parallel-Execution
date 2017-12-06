
package parallelExecution.com.thinksys.parallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages1.IndexPage;
import pages1.RegistrationPage;
import DataProvider.configDataProvider;

public class temp {

	
	public static void main(String args[])
	{
		configDataProvider config=new configDataProvider();
		
		System.setProperty("webdriver.chrome.driver", config.getchromePath());

		WebDriver  driver = new ChromeDriver();
		
		driver.get("http://live.guru99.com/index.php/customer/account/");
		
		IndexPage Index=new IndexPage(driver);
		
	}
	
	
	public String randomString()
	{
		
		
		return null;
		
	}
}
