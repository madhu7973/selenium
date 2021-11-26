package popups;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopup {
	WebDriver driver;

	@BeforeMethod
	public void setupEnvi() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://www.actitime.com/contact-support");

		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@Test
//	public void FUP() throws InterruptedException {
//		// Scrolling the page so that upload section is visible.
//		WebElement element = driver.findElement(By.xpath("//textarea[@id='question']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(1000);
//
//		// Locating the upload button and uploading document by providing the file
//		// location.
//		driver.findElement(By.xpath("//input[@id='fileupload']"))
//				.sendKeys("C:\\Users\\Madhusudan Devaraju\\Desktop\\FileUploadPopup.docx");
//		Thread.sleep(1000);
//
//		if (driver.findElement(By.xpath("//button[@class='fileupload-area__cancel']")).isDisplayed())
//			System.out.println("file uploaded suceessfully");
//		else
//			System.out.println("File not uploaded");
//	}

	@Test
	public void fileUpload() throws InterruptedException {
		driver.findElement(By.id("uploadfile_0"))
				.sendKeys("C:\\Users\\Madhusudan Devaraju\\Desktop\\FileUploadPopup.txt");
		Thread.sleep(3000);
	}

	@AfterMethod
	public void closeEnvi() {
		driver.close();
	}

}
