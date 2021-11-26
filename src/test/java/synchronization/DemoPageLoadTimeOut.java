package synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoPageLoadTimeOut {

	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// We cant apply the page load time for below site because, the DOM is already
		// displayed quickly and there is only a text change
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

		driver.findElement(By.xpath("//button")).click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

		String message = driver.findElement(By.xpath("//p[text()='WebDriver']")).getText();

		System.out.println(message);

		driver.quit();
	}

}
