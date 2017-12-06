import java.util.*;

/**
   An Array stack that implements StackInterface.
   @author Drue Hidalgo
*/

public final class ArrayStack<Integer> implements StackInterface<Integer>
{
    private final Integer[] array;
    private final static int ARRAY_SIZE = 10;
    private boolean initialized = false;
    private int size;
    private Integer[] stack;
    
    public ArrayStack()
    {
        this(ARRAY_SIZE);
    }
    
    public ArrayStack(int size)
    {
        @SuppressWarnings("unchecked")
        Integer[] tempArray = (Integer[])new Object[size];
        array = tempArray;
        initialized = true;
    }
    
    /** Adds a new entry to the top of this stack.
        @param newEntry  An object to be added to the stack. */
    public void push(Integer newValue)
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
        @return  Integerhe object at the top of the stack. 
        @throws  EmptyStackException if the stack is empty before the operation. */
    public Integer pop()
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
                Integer value = array[i-1];
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
       @return  Integerhe object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
    public Integer peek()
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
    
    public int getSize()
    {
        return size;
    }
    
    public Integer[] toArray()
    {
        return stack;
    }
    
    /** Detects whether this stack is empty.
       @return  Integerrue if the stack is empty. */  
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