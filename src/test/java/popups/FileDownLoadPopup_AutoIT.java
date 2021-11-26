package popups;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownLoadPopup_AutoIT {

	WebDriver driver;

	String fileDownloadPath = "D:\\Users\\maddevar\\Downloads\\FDP";

	@BeforeMethod
	public void setUp() {
//		HashMap<String, Object> chromePref = new HashMap<String, Object>();
//
//		// Do not show any popup when clicked on download link.
//		chromePref.put("profile.default_content_settings.popups", 0);
//
//		// Download to the specified location which is passed a value in the below
//		// statement
//		chromePref.put("download.default_directory", fileDownloadPath);
//
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", chromePref);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-xls-download/");
	}

	@Test
	public void FDP_AutoIT() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//a[contains(@href, 'XLSX_10.xlsx')]")).click();

		Runtime.getRuntime().exec(
				"D:\\AutoIT\\Scripts\\FileDownLoadPopup_AutoIT\\FDPAutoIT.exe");

//		File fileLocation = new File(fileDownloadPath);
//		File[] allFiles = fileLocation.listFiles();
//
//		boolean flag = false;
//
//		for (File file : allFiles)
//			if (file.getAbsolutePath().contains(".xlsx")) {
//				System.out.println("Downloaded file name is " + file.getName());
//				flag = file.delete();
//				break;
//			}
//		Assert.assertTrue(flag, "Downloaded file is not correct");

		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
