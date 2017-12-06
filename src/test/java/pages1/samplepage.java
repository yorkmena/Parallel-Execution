package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class samplepage {

	WebDriver driver;
	public samplepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}

	@FindBy(xpath="//*[@id='account']/a")
	WebElement Button;
	
	@FindBy(id="log")
	WebElement Log;
	
	@FindBy(id="pwd")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Login;
	
	
	public void clickButton()
	{
		Button.click();
	}
	
	public void sendLog(String data)
	{
		Log.sendKeys(data);
	}
	
	public void sendPassword(String data)
	{
		Password.sendKeys(data);
	}
	
	public void clickLogin()
	{
		Login.click();
	}
	
	
}
