package listBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingBootStrapDropdown {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void bootStrap() throws InterruptedException {

		// Clicks the bootstrap dropdown
		driver.findElement(By.xpath("//button[@type='button']")).click();

		// Storing all the dropdown options in a list.
		List<WebElement> bsOptions = driver
				.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li"));

		System.out.println("=======Taotal Number Of Options Avaialable=======");
		System.out.println();
		System.out.println(bsOptions.size());
//		System.out.println("=======Options Avaialable=======");
//		System.out.println();

		// Printing all the options
		for (WebElement s : bsOptions)
			System.out.println(s.getAttribute("class"));

		// Selecting all the unselected options and getting the text of those options
		// that are already selected by default
		for (int i = 0; i < bsOptions.size(); i++) {

			if ((bsOptions.get(i).getAttribute("class").equalsIgnoreCase("active"))) {
				System.out.println(bsOptions.get(i).getText());
				Thread.sleep(1000);
			} else
				bsOptions.get(i).click();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
