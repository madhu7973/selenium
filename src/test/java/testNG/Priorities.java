package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Priorities {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void testTitle() {
		System.out.println("testTitle() - Tiltle is " + driver.getTitle());
	}

	@Test(priority = 3)
	public void testImage() {
		boolean imageIsDisplayed = driver.findElement(By.xpath("//img[@alt = 'Google']")).isDisplayed();
		System.out.println("testImage() - image displayed - " + imageIsDisplayed);
	}

	@Test(priority = 4)
	public void testGmailLink() {
		boolean gmailIsDisplayed = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println("testGmailLink() - gamil link displayed - " + gmailIsDisplayed);
	}

	@Test(priority = 1)
	public void searchBox() {
		System.out.println("searchBox() - " + driver.getCurrentUrl());
	}

	@Test
	public void imageTextTest() {
		boolean imageText = driver.findElement(By.xpath("//a[text()='Images']")).isDisplayed();
		System.out.println("imageTextTest() - image text displayed - " + imageText);
	}

	@Test
	public void voiceBoxTest() {
		boolean voiceBox = driver.findElement(By.xpath("//div[@aria-label='Search by voice']")).isDisplayed();
		System.out.println("voiceBoxTest() - voice box displayed - " + voiceBox);
	}

	@Test
	public void googleSearchButtonTest() {
		boolean searchButton = driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).isDisplayed();
		System.out.println("googleSearchButtonTest() - search button displayed - " + searchButton);
	}

	@Test
	public void feelingLuckyTest() {
		boolean feelingLucky = driver.findElement(By.xpath("(//input[@name='btnI'])[2]")).isDisplayed();
		System.out.println("feelingLuckyTest() - feeling lucky button displayed - " + feelingLucky);
	}

	@Test
	public void googleAppsTest() {
		boolean googleApps = driver.findElement(By.xpath("//a[@title = 'Google apps']")).isDisplayed();
		System.out.println("googleAppsTest() - google apps icon displayed - " + googleApps);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}
