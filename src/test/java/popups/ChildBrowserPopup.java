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

public class ChildBrowserPopup {
	WebDriver driver;
	String winhan;
	Set<String> winhans;
	String parentTitle;

	@BeforeMethod
	public void setEnvi() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		parentTitle = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Test
//	public void CBPP() throws InterruptedException {
//		String parentWH = driver.getWindowHandle();
//
//		Set<String> allWH = driver.getWindowHandles();
//
//		System.out.println(allWH.size());
//
//		for (String s : allWH) {
//			driver.switchTo().window(s);
//
//			String title = driver.getTitle();
//
//			System.out.println(title);
//
//			// closes only the child browsers
//			if (s.equals(parentWH)) {
//				System.out.println("WindowHandle of parent window is " + parentWH);
//
//				 the below block closes the parent window and the child browser remain
//				 but the first else block should be commented
//
//				 driver.close
//				 break
//			}
//
//			else
//				driver.close();
//
//			 the below block closes only the popup with Amazon as title.
//			 else
//			 {
//			 if(s.equalsIgnoreCase("Amazon"))
//			 driver.close();
//			 }
//		}
//
//		Thread.sleep(2000);
//	}

	@Test
	public void childBrowserPopup() throws InterruptedException {
		driver.findElement(By.id("followall")).click();
		Thread.sleep(1000);

//		winhan = driver.getWindowHandle();

//		System.out.println(winhan);

		winhans = driver.getWindowHandles();

//		for (String s : winhans)
//			System.out.println(s);
	}

	@AfterMethod
	public void closeEnvi() throws InterruptedException {

		for (String s : winhans) {
			driver.switchTo().window(s);
			if (driver.getTitle().equalsIgnoreCase("Selenium Easy (@seleniumeasy) on Twitter")) {
				driver.close();
				break;
			}
		}

//		for (String windows : winhans) {
//			driver.switchTo().window(windows);
//			if (driver.getTitle().equalsIgnoreCase("Selenium Easy - Window Popup Modal Demo"))
//				System.out.println(driver.getTitle());
//			else
//				driver.close();
//			
//		}

	}
}