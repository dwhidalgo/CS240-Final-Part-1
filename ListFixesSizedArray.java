/**
	A list ADT using a fixed sized array.
	
	@author Drue Hidalgo
	@version 1.0
*/

public class ListFixesSizedArray<T> implements ListInterface<T>
{
	T[] list = (T[])new Object[10];
	int size = 0;
	
	public void add(T newItem) 
	{
		boolean added = false;
		int i = 0;
		if(size != 10)
		{
			while(!added && i<list.length)
			{
				if(list[i] == null)
				{
					list[i] = newItem;
					added = true;
				}
			}
		}
		
	}

	public T remove(int position) throws EmptyListException
	{
		if(isEmpty())
		{
			throw new EmptyListException();
		}
		
		T removed = list[position];
		list[position] = null;
		size--;
			
		return removed;
	}


	public T view(int position) throws EmptyListException
	{
		if(isEmpty())
		{
			throw new EmptyListException();
		}
		return list[position];
	}


	public boolean contains(T item) 
	{
		for(T e: list)
		{
			if(e==item)
			{
				return true;
			}
		}
		return false;
	}


	public int getLength() 
	{
		return size;
	}


	public boolean isEmpty() 
	{
		return size == 0;
	}


	public T replace(int position, T item) throws EmptyListException
	{
		if(isEmpty()) 
		{
			throw new EmptyListException();
		}
		T replaced = list[position];
		list[position] = item;
		
		return replaced;
	}

	public void clear() 
	{
		for(T e : list)
		{
			e = null;
		}
		size = 0;
	}
	
}