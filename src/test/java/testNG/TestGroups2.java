package testNG;

import org.testng.annotations.Test;

public class TestGroups2 {
	
	@Test (groups= {"regression", "sanity"})
	public void tc_6()
	{
		System.out.println("tc - 6: regression, sanity");
	}

	@Test (groups= {"system", "smoke"})
	public void tc_7()
	{
		System.out.println("tc - 7: system, smoke");
	}
	
	@Test (groups= {"system"})
	public void tc_8()
	{
		System.out.println("tc - 8: system");
	}
	
	@Test (groups= {"regression", "system"})
	public void tc_9()
	{
		System.out.println("tc - 9: regression, system");
	}
	
	@Test (groups= {"smoke", "system, unit"})
	public void tc_10()
	{
		System.out.println("tc - 10: smoke, system, unit");
	}

}
