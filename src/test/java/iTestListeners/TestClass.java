package iTestListeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(iTestListeners.ListenersDemo.class)
public class TestClass 
{
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.live.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void usrname()
	{
		driver.findElement(By.xpath("//input[@type= 'email']")).sendKeys("madhu7973@gmail.com");
		driver.findElement(By.xpath("//input[@id= 'idSIButton9']")).click();
		if (driver.findElement(By.xpath("//div[@id= 'usernameError']")).isDisplayed())
			System.out.println("error massage displayed: "+ driver.findElement(By.xpath("//div[@id= 'usernameError']")).getText());
		else System.out.println("Error message not displayed");
	}

	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}
