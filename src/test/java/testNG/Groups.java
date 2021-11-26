package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Groups {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test (priority = 2)
	public void testTitle() {
		System.out.println("testTitle() - Tiltle is " + driver.getTitle());
	}

	@Test (priority = 3)
	public void testImage() {
		boolean imageIsDisplayed = driver.findElement(By.xpath("//img[@alt = 'Google']")).isDisplayed();
		System.out.println("testImage() - image displayed - " + imageIsDisplayed);
	}

	@Test (priority = 4)
	public void testGmailLink() {
		boolean gmailIsDisplayed = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println("testGmailLink() - gamil link displayed - " + gmailIsDisplayed);
	}

	@Test (priority = 1)
	public void searchBox() {
		System.out.println("searchBox() - " + driver.getCurrentUrl());
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}
