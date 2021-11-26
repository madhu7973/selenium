package findElements;

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

public class ProductsInPLP {
	WebDriver driver;

	@BeforeMethod
	public void openEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sallybeauty.com/nails/nail-polish/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void ProdCount() {
		List<WebElement> allProd = driver.findElements(By.xpath("//a[@class='name-link']"));
		System.out.println(allProd.size());

		for (int i = 0; i < allProd.size(); i++)
			if (i == 19) {
				allProd.get(i).click();
				if (driver.findElement(By.xpath("//ol[@class='breadcrumb']")).isDisplayed())
					;
				System.out.println("PDP displayed");
				break;
			}
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}
}
