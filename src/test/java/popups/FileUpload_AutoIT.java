package popups;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload_AutoIT {
	WebDriver driver;
	
	@BeforeMethod
	public void setupEnvi() {
	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.get("https://www.actitime.com/contact-support");
		driver.get("http://tinyupload.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void dummy() throws IOException
	{
		
	}

//	@Test
//	public void FUPAutoIT() throws IOException, InterruptedException {
//		driver.findElement(By.xpath("//input[@id='fileupload']")).click();
//		Thread.sleep(1000);
//		Runtime.getRuntime().exec("E:\\AutoITScripts\\FileUpload.exe");
//		Thread.sleep(2000);
//	}

//	@Test
//	public void fileUpload_AutoIT() throws InterruptedException, IOException {
//		driver.findElement(By.className("pole_plik")).click();
//		Runtime.getRuntime().exec("D:\\AutoIT\\Scripts\\FileUploadScript\\FileUploadScript.exe");
//		Thread.sleep(1000);
//	}
	

	@AfterMethod
	public void closeEnvi() {
		driver.quit();
	}

}
