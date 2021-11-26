package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Enable_AlwaysRun {

//	enabled = false, dependent on other method.

//	@Test(dependsOnMethods = "tc_3", enabled = false)
//	public void tc_1() {
//		System.out.println("tc1 - depends on tc3");
//	}
//
//	@Test(alwaysRun = true)
//	public void tc_3() {
//		System.out.println("tc3");
//	}

//	enabled = false, creates dependency to tc_4 which is set to alwaysRun=true
//	this leads to error

//	@Test(enabled = false)
//	public void tc_2() {
//		System.out.println("tc_2");
//	}
//
//	@Test(dependsOnMethods = "tc_2", alwaysRun = true)
//	public void tc_4() {
//		System.out.println("tc_4 - depends on tc_2");
//	}

//	enabled = false which is set to alwayRun = true, creates dependency to tc_5
//	this leads to error

//	@Test(enabled = false ,alwaysRun = true)
//	public void tc_5() {
//		System.out.println("tc_5");
//	}
//
//	@Test(dependsOnMethods = "tc_5")
//	public void tc_6() {
//		System.out.println("tc_6 - depends on tc_5");
//	}

//	enabled = false alwaysRun=true, created dependency to tc_8 which is alwaysRun = true 
	
//	@Test(alwaysRun = true, dependsOnMethods = "tc_8")
//	public void tc_7() {
//		System.out.println("tc7 - depends on tc_8");
//	}
//
//	@Test(enabled = false, alwaysRun = true)
//	public void tc_8() {
//		System.out.println("tc_8");
//	}

//	enabled = false, and alwaysRun = true

	@Test(alwaysRun = false, enabled = false)
	public void tc_9() {
		System.out.println("enabled and disabled");
	}

//	@Test
//	public void tc_10() {
//		System.out.println("tc_10 - fails - created dependency on tc_11");
//		Assert.fail();
//	}
//
//	@Test(alwaysRun = true, dependsOnMethods = "tc_10")
//	public void tc_11() {
//		System.out.println("tc_11 - alwaysRun - dependent on tc_10");
//	}
}
