package testNG;

import org.testng.annotations.Test;

public class TestGroups3 {

	@Test(groups = { "unit", "sanity" })
	public void tc_11() {
		System.out.println("tc - 11: unit, sanity");
	}

	@Test(groups = { "system", "regression" })
	public void tc_12() {
		System.out.println("tc -12: system, regression");
	}

	@Test(groups = { "unit, smoke" })
	public void tc_13() {
		System.out.println("tc - 13: unit, smoke");
	}

	@Test(groups = { "smoke" })
	public void tc_14() {
		System.out.println("tc - 14: smoke");
	}

	@Test(groups = { "unit", "regression", "smoke" })
	public void tc_15() {
		System.out.println("tc - 15: unit, regression, smoke");
	}

}
