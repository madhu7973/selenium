package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlignmentVerification 
{		
	WebDriver driver;
	WebElement un;
	WebElement pwd;

	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		un = driver.findElement(By.xpath("//input[@id='username']"));
		pwd = driver.findElement(By.xpath("//input[@id='password']"));
	}

	@Test
	public void pwduserFieldAlignment()
	{
		int x1 = un.getLocation().getX();
		int x2 = pwd.getLocation().getX();
		System.out.println("location of un field: " + x1);
		System.out.println("location of pwd field: " + x2);
		if (x1==x2)
			System.out.println("username and password fields are aligned");
		else System.out.println("username and password fields are not aligned");
	}

	@Test
	public void pwduserFieldWidth()
	{
		int x3 = un.getSize().getWidth();
		int x4 = un.getSize().getWidth();
		System.out.println("width of un field: " + x3);
		System.out.println("width of un field: " + x4);
		if (x3 == x4)
			System.out.println("username and password fields have same width");
		else System.out.println("username and password fields have different width");
	}

	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}