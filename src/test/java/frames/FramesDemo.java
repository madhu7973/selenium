package frames;

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

public class FramesDemo {
	WebDriver driver;

	@BeforeMethod
	public void openEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void frames() throws InterruptedException {
//		driver.switchTo().frame("iframe1");
//		driver.findElement(By.xpath("//input[@name=\"First_Name\"]")).sendKeys("frames");
//		Thread.sleep(2000);
//		
//		driver.switchTo().defaultContent();

//		driver.findElement(By.xpath("/html/body/a")).click();
//		Thread.sleep(2000);
//		driver.navigate().back();

		Actions actions = new Actions(driver);
		WebElement frame = driver.findElement(By.xpath("//iframe[@name=\"iframe1\"]"));
		driver.switchTo().defaultContent();

		Thread.sleep(2000);

//		driver.switchTo().parentFrame();
//		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//input[@id='gsc-i-id2']")).sendKeys("selenium");
//		Thread.sleep(2000);
//		driver.switchTo().defaultContent();
//		WebElement element = driver.findElement(By.name("selenium"));
//		driver.switchTo().frame(element);
//		driver.findElement(By.xpath("//a[@title = 'Selenium Projects']")).click();
//		Thread.sleep(2000);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
