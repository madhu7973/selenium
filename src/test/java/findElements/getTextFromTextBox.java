package findElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextFromTextBox {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://account.genndi.com/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void getText() {
		WebElement element = driver.findElement(By.xpath("//input[@name='username']"));
		String text = element.getAttribute("placeholder");
		System.out.println(text);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}
