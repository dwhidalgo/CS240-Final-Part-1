import java.util.*;
/**
   An array queue that implements StackInterface.
   @author Drue Hidalgo
*/

public final class ArrayQueue<T> implements QueueInterface<T>
{
    private final static int SIZE = 10;
    private T[] stack;
    private int front;
    private int back;
    private boolean initialized = false;
    
    public ArrayQueue()
    {
        this(SIZE);
    }
    
    public ArrayQueue(int size)
    {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[size];
        stack = tempStack;
        front = 0;
        back = 0;
    }
    /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
    public void enqueue(T newEntry)
    {
        checkInitialization();
        if(back == SIZE-1)
        {
            System.out.print("No room to add.");
        }
        else
        {
            stack[back] = newEntry;
            
            back++;
            
            if (back == 10)
            {
                back = 0;
            }
        }
    }
    
    /** Removes and returns the entry at the front of this queue.
        @return  The object at the front of the queue. 
        @throws  EmptyQueueException if the queue is empty before the operation. */
    public T dequeue()
    {
        checkInitialization();
        if(isEmpty())
        {
            System.out.println("Queue is empty.");
            return null;
        }
        else
        {
            T temp = stack[front];
            stack[front] = null;
            if(front == back)
            {
                back++;
            }
            front++;
            return temp;
        }
    }
    
    /**  Retrieves the entry at the front of this queue.
        @return  The object at the front of the queue.
        @throws  EmptyQueueException if the queue is empty. */
    public T getFront()
    {
        return stack[front];
    }
    
    /** Detects whether this queue is empty.
        @return  True if the queue is empty, or false otherwise. */
    public boolean isEmpty()
    {
        boolean empty = true;
        
        for (int i = 0; i < SIZE; i++)
        {
            if (!(stack[i] == null))
            {
                empty = false;
            }
        }
        
        return empty;
    }
    
    /** Removes all entries from this queue. */
    public void clear()
    {
        for(int i=0; i<SIZE; i++)
        {
            stack[i] = null;
        }
    }
    
    private void checkInitialization()
    {
        if(!initialized)
        {
            throw new SecurityException("Not initialized properly.");
        }
    }
}   