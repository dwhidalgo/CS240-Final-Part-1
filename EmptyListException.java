public class EmptyListException extends RuntimeException
{
	private static final String message = "The list is empty.";
	
	public EmptyListException()
	{
		super(message);
	}
}