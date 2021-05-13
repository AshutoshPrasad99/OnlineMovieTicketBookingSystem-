package exception;

public class InvalidPasswordSizeException extends Exception
{
	public String getMessage()
	{
		return " Password should be atleast 8 character long.";
	}
}
