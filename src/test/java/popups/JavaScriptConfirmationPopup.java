package popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptConfirmationPopup 
{
	WebDriver driver;
	@BeforeMethod
	public void openEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void JSConfimation() throws InterruptedException	
	{
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(1500);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().accept();
	}
	
	@AfterMethod
	public void closeEnvi()
	{
		driver.close();
	}

}
