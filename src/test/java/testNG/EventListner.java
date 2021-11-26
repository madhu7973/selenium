package testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListner extends Event implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("*****TestMethodStart*****");
		System.out.println(result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*****TestMethodFailur*****");
		System.out.println(result.getName());

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("C:\\Users\\Madhusudan Devaraju\\Desktop\\ScreenShot\\" + result.getName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		System.err.println("*****TestMethodSuccess*****");
		System.out.println(result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		System.out.println("starting execution of test methods");

	}

	public void onFinish(ITestContext context) {

		System.out.println("ending execution of test methods");
	}
}
