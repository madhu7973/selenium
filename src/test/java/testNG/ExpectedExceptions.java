package testNG;

import org.testng.annotations.Test;

public class ExpectedExceptions {

	@Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
	public void expectedException() {

		String stringArray[] = { "one", "two", "three" };

		for (int i = 0; i < stringArray.length; i++) {
			String s = stringArray[i + 1];
			System.out.println(s);
		}
	}
}
