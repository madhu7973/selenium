package synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static WebDriver driver;
//	public static String sxpath;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

		driver.findElement(By.xpath("//button")).click();

//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='WebDriver']")));

//		sxpath = "//p[text()='WebDriver']";

		// calls the below generic explicit wait method
		ExplicitWait.expWait("//p[text()='WebDriver']", 20);

		System.out.println(driver.findElement(By.xpath("//p[text()='WebDriver']")).getText());
		driver.quit();
	}

	// since explicit wait is only applicable where the method is called.
	// So we need to call it when ever and where all needed.

	// hence the below generic method is constructed where we need to pass the xpath
	// of the element which is yet to be displayed and time to wait as parameters.
	public static void expWait(String sxpath, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sxpath)));
		// return;
	}
}
