package synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicitwait {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

		driver.findElement(By.xpath("//button")).click();

		// implicit wait applied to all the findElements method so we do not
		// to call implicit wait for each findElement method.
		// Implicit wait sets the wait time that the driver should wait while searching
		// for an element and that element is not available immediately.
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String message = driver.findElement(By.xpath("//p[text()='WebDriver']")).getText();

		System.out.println(message);

		driver.quit();
	}

}
