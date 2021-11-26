package mouseActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions_UsingRobotClass {

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
	public void mouseActions() throws AWTException, InterruptedException {
		WebElement searchBox = driver.findElement(By.cssSelector("#global-search-input"));
		
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(searchBox).click().perform(); 
		 * Thread.sleep(2500);
		 * searchBox.click(); 
		 * Point pt = searchBox.getLocation(); 
		 * int xaxis = pt.getX();
		 * int yaxis = pt.getY();
		 */

		int xaxis = searchBox.getLocation().getX();
		int yaxis = searchBox.getLocation().getY();
		System.out.println("x-axis: " + xaxis + " " + "yaxis: " + yaxis);

		/*
		 * Using robot class we can not mouse click or mouse hover directly using the
		 * webelement paths. Robot class only performs the action on the current active
		 * element. So first we need to find the x and y co-ordinates, mouse over it and
		 * then perform the action.
		 */

		Robot robot = new Robot();
		robot.mouseMove(searchBox.getLocation().x, searchBox.getLocation().y);
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseWheel(3);
		robot.mouseMove(xaxis, yaxis);
		Thread.sleep(1500);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
