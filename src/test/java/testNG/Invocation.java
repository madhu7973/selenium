package testNG;

import org.testng.annotations.Test;

public class Invocation {

//	@Test(invocationCount = 9)
	public void invocationCount() {
		System.out.println("this method will be executed 9 times");
	}

//	@Test(invocationTimeOut = 10, invocationCount = 900)
	public void invocationTimeOut() {
		System.out.println("invocationTimeOut");
	}

	@Test(timeOut = 10)
	public void loop() {
		boolean i = true;
		while (i)
			System.out.println("pass");
	}
}
