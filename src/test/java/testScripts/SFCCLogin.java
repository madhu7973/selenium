package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFCCLogin {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void enterCredentialsByXpath() {
		driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys("madhu");
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("sudan");
		driver.findElement(By.xpath("//input[@id = 'rememberUn']")).click();
		// driver.findElement(By.xpath("//input[@id = 'Login']")).click();
		driver.findElement(By.cssSelector("input.button.r4.wide.primary")).click();

	}

	@Test(priority = 2)
	public void enterCredentialyByCSS() {
		driver.findElement(By.cssSelector("input[name = 'username']")).sendKeys("deva");
		driver.findElement(By.cssSelector("input[id = 'password']")).sendKeys("raju");
		driver.findElement(By.cssSelector("input[name= 'rememberUn']")).click();
		driver.findElement(By.cssSelector("input[name ='Login']")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}