package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelSuiteExecution {

	@Test(priority = 1)
	public void seleniumHP() throws InterruptedException {
		System.out.println("ParallelSuiteExecution - selenium home page - p1");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.dev/");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

	@Test(priority = 2)
	public void mavenRepo() throws InterruptedException {
		System.out.println("ParallelSuiteExecution - Maven repo - p2");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mvnrepository.com/");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Maven Repository: Search/Browse/Explore");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

	@Test(priority = 3)
	public void eclipseHP() throws InterruptedException {
		System.out.println("ParallelSuiteExecution - eclipse home - p3");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.eclipse.org/");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Enabling Open Innovation & Collaboration | The Eclipse Foundation");
		Thread.sleep(1000);
		driver.close();
		soft.assertAll();
	}

}
