package mouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover_AndClick 
{
	WebDriver driver;
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/?ir=1");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void hover_click() throws InterruptedException 
	{
		WebElement element = driver.findElement(By.xpath("//a[text() = 'PRODUCTS']"));
		new Actions(driver).moveToElement(element).perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//small[text()='Sales force automation and CRM']")).click();
		Thread.sleep(1500);
	}

	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}
