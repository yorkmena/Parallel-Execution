package Factory1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import DataProvider.configDataProvider;

public class Browserfactory {

	
	WebDriver driver;
	public Browserfactory(WebDriver driver) {
		this.driver=driver;
	}
	configDataProvider configData=new configDataProvider();
	
	public WebDriver getBrowser(String browser)
	{
		 if(browser.equalsIgnoreCase("firefox")) {

			  System.setProperty("webdriver.gecko.driver", configData.getvalue("firefoxPath"));
			  driver = new FirefoxDriver();

		  // If browser is IE, then do this	  

		  }else if (browser.equalsIgnoreCase("chrome")) { 

			  // Here I am setting up the path for my ChromeDriver

			  System.setProperty("webdriver.chrome.driver", configData.getchromePath());

			  driver = new ChromeDriver();
		  } 
		
		return driver;
	}
}
