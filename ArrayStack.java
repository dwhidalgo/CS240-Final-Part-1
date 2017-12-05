import java.util.*;

/**
   An Array stack that implements StackInterface.
   @author Drue Hidalgo
*/

public final class ArrayStack<T> implements StackInterface<T>
{
	private final T[] array;
	private final int ARRAY_SIZE = 10;
	private boolean initialized = false;
	
	public ArrayStack()
	{
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[])new Object[ARRAY_SIZE];
		array = tempArray;
		initialized = true;
	}
	
	/** Adds a new entry to the top of this stack.
		@param newEntry  An object to be added to the stack. */
	public void push(T newValue)
	{
		checkInitialization();
		
		int i = 0;
		int topValue;
		
		while(array[i] != null && i < 10)
		{
			i++;
		}
		
		if(i < 10)
		{
			topValue = i;
		}
		else
		{
			System.out.println("Stack is full.");
		}
		array[i] = newValue;
	}
	
	/** Removes and returns this stack's top entry.
		@return  The object at the top of the stack. 
		@throws  EmptyStackException if the stack is empty before the operation. */
	public T pop()
	{
		checkInitialization();
		
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			int i = 0;
			
			while(array[i]!=null && i<10)
			{
				i++;
			}
			if(i<10)
			{
				T value = array[i-1];
				array[i-1] = null;
				return value;
			}
			else
			{
				return null;
			}
		}
	}

	/** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
	public T peek()
	{
		checkInitialization();
		
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			int i = 0;
			
			while(array[i]!=null && i<10)
			{
				i++;
			}
			
			if(i<10)
			{
				return array[i-1];
			}
			else
			{
				return null;
			}
		}
	}
	
	/** Detects whether this stack is empty.
       @return  True if the stack is empty. */	
	public boolean isEmpty()
	{
		checkInitialization();
		
		boolean empty = true;
		for(int i=0; i<ARRAY_SIZE; i++)
		{
			if(array[i]!=null)
			{
				empty = false;
			}
		}
		
		return empty;
	}
	
	public void clear()
	{
	    for(int i = ARRAY_SIZE-1; i >= 0; i--)
	    {
	        array[i] = null;
	    }
	}
	private void checkInitialization()
	{
	   if(!initialized)
	      throw new SecurityException("Not initialized properly.");
	}
}