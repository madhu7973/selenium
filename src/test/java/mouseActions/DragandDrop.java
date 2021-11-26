package mouseActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {
	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://marcojakob.github.io/dart-dnd/basic/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void dragAndDrop() throws InterruptedException {
		List<WebElement> dd = driver.findElements(By.cssSelector(".document"));
		System.out.println(dd.size());
		Actions act = new Actions(driver);
		for (int i = 0; i <= dd.size(); i++) {
			act.clickAndHold(dd.get(i)).moveToElement(driver.findElement(By.cssSelector(".trash"))).release().build()
					.perform();
			// we can also use drag and drop function
			Thread.sleep(500);
		}

	}

	@Test
	public void dragDrop() throws InterruptedException {
		List<WebElement> src = driver.findElements(By.cssSelector(".document"));
		WebElement tar = driver.findElement(By.cssSelector(".trash"));
		Actions act = new Actions(driver);

		for (int i = 0; i <= src.size() - 1; i++) {
			act.dragAndDrop(src.get(i), tar).release().build().perform();
			Thread.sleep(500);
		}
	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
