/**
	A single linked node that stores pointers to the previous node and stores data.
	@author Drue Hidalgo
 */
 public class SLNode<T>
 {
	private SLNode<T> front;
	private T data;
	 
	public SLNode
	{
		front = null;
		data = null;
	}
	
	public SLNode(T newData)
	{
		front = null;
		data = newData;
	}
	
	public void setPrev(SLNode<T> frontNode)
	{
		front = frontNode;
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public SLNode<T> getPrev()
	{
		return front;
	}
	
	public T getData()
	{
		return data;
	}
 }