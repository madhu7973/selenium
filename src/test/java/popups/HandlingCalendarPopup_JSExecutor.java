package popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCalendarPopup_JSExecutor {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void calPopu_JSE() throws InterruptedException {
		
		//Locating the date field.
		WebElement element = driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_view_date1\"]"));
		
		//Setting required date.
		String dateValue = "27-03-2020";
		
		//Using JavaScriptExecutor to enter the dates directly into the field.
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value', '" + dateValue + "');", element);
		Thread.sleep(2000);
	}

	@AfterTest
	public void closeEnvi() {
		driver.quit();
	}

}
