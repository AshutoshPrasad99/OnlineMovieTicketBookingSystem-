package exception;

public class InvalidSeatNumberException extends Exception
{
	public String getMessage()
	{
		return " Please select the seat first.";
	}
}
