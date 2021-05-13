package validation;

public class Validate
{
	public static boolean isValidContact(long contact)
	{
		boolean flag = false;
		if(Long.toString(contact).length() == 10)
		{
			flag = true;
		}
		return flag;
	}
	
	public static boolean isValidPassword(String password)
	{
		boolean flag = false;
		if(password.length() > 7)
		{
			flag = true;
		}
		return flag;
	}
}
