package parallelExecution.com.thinksys.parallelExecution;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import pages1.IndexPage;
import pages1.MobilePage;

public class Stest extends Testbase {

	@Test
	public void VerifyTitle()
	{
		driver.get("http://live.guru99.com/index.php/"); 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Index.clickOnMobile();
		//logger.log(LogStatus.INFO, "Clicked on Mobile");
		Assert.assertEquals(driver.getTitle(),"Mobile","Title Verified");
		
	}
	@Test(enabled=false)
	public void VefifySorting()
	{
		
		driver.get("http://live.guru99.com/index.php/"); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Index.clickOnMobile();
		Mobile.SortBy("name");
		List<WebElement> order=driver.findElements(By.cssSelector(".product-image>img"));
		List<String>OrderName=new LinkedList<String>();
		for(WebElement ele : order)
		{
			ele.getAttribute("alt");
			OrderName.add(ele.getAttribute("alt"));
		}
		String pre="";
		Boolean b=true;
		int i;
		for(String str:OrderName)
		{ 
			if (pre.compareTo(str)>0)
			{
				i=pre.compareTo(str);
				System.out.println(pre+"------"+str+"------"+i);
			    b=false;
			}
		pre=str;
		}
		
		Assert.assertTrue(true, "Verifying Sorting Passed");
	}
	
	
	
	
	
}
