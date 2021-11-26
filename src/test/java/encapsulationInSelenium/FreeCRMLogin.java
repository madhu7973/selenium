package encapsulationInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FreeCRMLogin 
{
	private WebElement UNTB;
	private WebElement PTB;
	private WebElement BTN;
	
	public FreeCRMLogin(WebDriver driver)
	{
		UNTB = driver.findElement(By.xpath("//input[@name='username']"));
		PTB = driver.findElement(By.xpath("//input[@name='password']"));
	}

	public void setUserName(String un)
	{
		UNTB.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		PTB.sendKeys(pwd);
	}

}

