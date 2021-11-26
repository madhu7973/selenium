package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleProgram {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://gmail.com");
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		driver.get("https://facebook.com");
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		Thread.sleep(1000);
		SoftAssert soft = new SoftAssert();
		// soft.assertEquals(expected, message);
	}

}