package popups;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlertPopup {
	WebDriver driver;

	@BeforeMethod
	public void openEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void alertPopup() throws InterruptedException {
//		driver.findElement(By.xpath("//input[@name='proceed']")).click();
//		Thread.sleep(1500);
//		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//		Thread.sleep(1500);

		driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]")).click();
		Set<String> windowhandles1 = driver.getWindowHandles();
		for (String whs1 : windowhandles1)
			System.out.println(whs1);
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}

	/*
	 * @Test public void confirmationPopup() throws InterruptedException {
	 * driver.findElement(By.
	 * xpath("(//button[@class=\"btn btn-default btn-lg\"])[1]")).click();
	 * Set<String> windowhandles2 = driver.getWindowHandles(); for (String whs2 :
	 * windowhandles2) System.out.println(whs2); Thread.sleep(1000);
	 * driver.switchTo().alert().dismiss(); Thread.sleep(1000); }
	 */

	/*
	 * @Test public void promptPopup() throws InterruptedException {
	 * driver.findElement(By.
	 * xpath("(//button[@class=\"btn btn-default btn-lg\"])[2]")).click();
	 * Set<String> windowhandles3 = driver.getWindowHandles(); for (String whs3 :
	 * windowhandles3) System.out.println(whs3); Thread.sleep(1000); Alert promptBox
	 * = driver.switchTo().alert(); promptBox.sendKeys("madhusudan");
	 * Thread.sleep(1000); promptBox.accept(); Thread.sleep(1000); }
	 */

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
