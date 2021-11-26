
package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Absolutexpath 
{
	WebDriver driver;


	@BeforeMethod
	public void setupEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/interview.php");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void absolutXpath1() throws InterruptedException
	{
		driver.findElement(By.xpath("//section[@id='content']/div/div/div/div/ul/li[1]")).click();
		Thread.sleep(2000);
	}

	@Test
	public void absolutXpath2() throws InterruptedException
	{

		driver.findElement(By.xpath("//section[@id='content']/div/div/div/div/ul/li[1]/following-sibling::li[1]")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void absolutXpath3() throws InterruptedException
	{
		driver.findElement(By.xpath("")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void absolutXpath4() throws InterruptedException
	{
		driver.findElement(By.xpath("")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}

}
