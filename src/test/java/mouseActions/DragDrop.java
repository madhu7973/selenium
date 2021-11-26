package mouseActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://bestvpn.org/html5demos/drag/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void dragDrop() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("//h1[text()='Drag and drop']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(1500);

		List<WebElement> draggables = driver.findElements(By.xpath("(//ul)[6]//li//a"));
		System.out.println(draggables.size());

		Actions act = new Actions(driver);
		for (int i = 0; i < draggables.size(); i++) {
			// WebElement source = draggables.get(i);
			// WebElement target = driver.findElement(By.xpath("//div[@id='bin']"));
			act.clickAndHold(draggables.get(i)).moveToElement(driver.findElement(By.xpath("//div[@id='bin']")))
					.release().build().perform();
			Thread.sleep(1000);
		}
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}
