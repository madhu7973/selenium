package testNG;

import org.testng.annotations.Test;

public class Dependency_TestMethod {

	@Test(priority = 1, dependsOnMethods = { "tc_3" })
	public void tc_1() {
		System.out.println("tc1 - depends on tc3");
	}

	@Test(dependsOnMethods = { "tc_5", "tc_3" })
	public void tc_2() {
		System.out.println("tc2 - depends on tc5 and tc3");
	}

	@Test(priority = 3)
	public void tc_3() {
		System.out.println("tc3");
	}

	@Test(dependsOnMethods = { "tc_2" })
	public void tc_4() {
		System.out.println("tc4 - depends on tc2");
	}

	@Test(dependsOnMethods = { "tc_4" })
	public void tc_5() {
		System.out.println("tc5 - depends on tc1");
	}
}
