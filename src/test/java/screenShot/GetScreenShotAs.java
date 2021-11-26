package screenShot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetScreenShotAs {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void takeScreenShot() throws IOException, InterruptedException
	{
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//a[@title='Get Selenium']")).click();
		
		Thread.sleep(5000);
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		
		//File srcFile = ss.getScreenshotAs(OutputType.FILE);
		//File destFile = new File ("D:\\ProjectsWorkspace\\Selenium\\Selenium\\src\\screenShot\\" + System.currentTimeMillis()+".png");
		FileUtils.copyFile(ss.getScreenshotAs(OutputType.FILE), 
				new File ("D:\\ProjectsWorkspace\\Selenium\\Selenium\\src\\screenShot\\" 
							+ System.currentTimeMillis()+".png"));
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.quit();
	}

}
