package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(EventListner.class)
public class Event {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@Test
	public void login() {
		Assert.assertTrue(false);
	}

	@Test(enabled = false)
	public void checkOut() {
		Assert.assertTrue(true);
	}

	@Test
	public void accountCreation() {
		Assert.assertTrue(false);
	}

	@Test
	public void addToBag() {
		Assert.assertTrue(true);
	}

	@Test
	public void wishList() {
		Assert.assertTrue(false);
	}

	@Test
	public void search() {
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
