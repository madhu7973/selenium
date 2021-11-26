package popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopup 
{
	WebDriver driver;
	
	@BeforeMethod
	public void openEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/download/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void WinPopup1() throws AWTException, InterruptedException
	{
		//method1 using keyevent of robot class
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_P);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
	}
	
//	@Test
//	public void WinPopup2() throws AWTException, InterruptedException
//	{
//		//method2 using keys.control of robot class
//		Robot r = new Robot();
//		driver.findElement(By.xpath("//a[@href='https://goo.gl/4g538W']")).sendKeys(Keys.CONTROL+"P");
//		Thread.sleep(2000);
//		r.keyPress(KeyEvent.VK_ESCAPE);
//		r.keyRelease(KeyEvent.VK_ESCAPE);
//		Thread.sleep(2000);
//	}

	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}
}
