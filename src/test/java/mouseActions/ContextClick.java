package mouseActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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

public class ContextClick {
	WebDriver driver;

	@BeforeMethod
	public void openEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.walmart.com/");
		
	}

	@Test
	public void contextClick() throws InterruptedException, AWTException {
		WebElement element = driver.findElement(By.cssSelector("#global-search-input"));
		Actions act = new Actions(driver);
		act.click(element).contextClick().sendKeys(Keys.SHIFT, "watches").release().sendKeys(Keys.SHIFT, " SHIRTS").perform();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
