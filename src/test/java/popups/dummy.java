package popups;

public class dummy 
{
	
	public static void main(String[] args) 
	{
		String string = "h8ll0";

		char[] carray = string.toCharArray();

		for (char c : carray) {

			if (Character.isDigit(c)) 
			{
				System.out.println(c);
			}
		}
	}
}