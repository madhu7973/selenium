package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterization {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	@Parameters({ "username", "password" })
	public void test(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class='head']//h1")).getText());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}
}
