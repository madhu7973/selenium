package keyBoardEvents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvents_ActionsClass {

	WebDriver driver;

	@BeforeMethod
	public void setEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.walmart.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void keyBoardEvents_acionClass() throws InterruptedException {
//		WebElement element = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

		Actions actions = new Actions(driver);
//		actions.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("watches").build().perform();

//		actions.sendKeys(element, Keys.SHIFT).sendKeys("watches").perform();
//		actions.sendKeys(Keys.SHIFT).perform();
//		actions.keyUp(Keys.SHIFT);
//		actions.keyUp(element, Keys.ENTER);
//		Thread.sleep(2000);
//		actions.sendKeys(Keys.chord(Keys.CONTROL, "R")).perform();
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id=\"global-search-input\"]"));
		searchbox.sendKeys("shirt");
		Thread.sleep(1500);
		actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("x").keyUp(Keys.COMMAND).perform();
		Thread.sleep(1500);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
