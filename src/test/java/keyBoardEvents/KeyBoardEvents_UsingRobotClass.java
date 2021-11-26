package keyBoardEvents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvents_UsingRobotClass {

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
	public void keyBoardEvents_robotClass() throws AWTException, InterruptedException {
		WebElement searchBox = driver.findElement(By.name("query"));

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);

		searchBox.sendKeys("");
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(1000);

		searchBox.sendKeys("");
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		Thread.sleep(1000);

		searchBox.sendKeys("");
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		Thread.sleep(1000);

		robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		
		//using combination of keys.
		
		searchBox.sendKeys("");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_R);
		
	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}
}
