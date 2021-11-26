package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaits 
{
	WebDriver driver;
	@BeforeMethod
	public void setEnvi()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hrcrm.dosje.in/auth/login");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void POPD()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("asd@qwe.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("asd@qwe.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']")));

		if (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed())
			System.out.println("error mesage displayed");
		else System.out.println("error message not diplayed");
	}

	@AfterMethod
	public void CloseEnvi()
	{
		driver.close();
	}

}