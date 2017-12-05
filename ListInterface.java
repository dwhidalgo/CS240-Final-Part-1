/**
	An Interface of an ADT LIST
	
	@author Drue Hidalgo
	@version 1.0
*/

public interface ListInterface<T>
{
	/**	
		This adds an item to the bottom of the list.
		The list size will be increased by 1.
		Other item positions will be unaffected.
		@param item THe Object to be added.
	*/
	public void add(T item);
	
	/**
		This removes a specific position in the list.
		The list size will be decreased by 1.
		Other item positions below the specified index position will be effected.
		@param position The location of the item to be removed.
		@throws IndexOutOfBoundsException if the specified index is not part of the list.
	*/
	public T remove(int position) throws EmptyListException;
	
	/**
		Replaces the item in a certain poistion.
		@param position The position to replace an item in the list.
		@param item The item to replace it with.
	*/
	public T replace(int position, T item) throws EmptyListException;
	
	/**
		Views an Item in a certain position.
		The items in the list will not be effected.
		@param position The location of the item on the list to be returned.
		@return T The item at the specified position in the list.
	*/
	public T view(int position) throws EmptyListException;
	
	/**
		Returns an item based on a position specified.
		@param item The item to see if the list contains.
		@return boolean True if the item is there, false if it is not.
	*/
	public boolean contains(T item);
	
	/**
		Gets the lenght of the list.
		@return int The length of the list.
	*/
	public int getLength();
	
	/**
		Checks if the list is empty
		@return boolean True if the list is empty, false if it is not.
	*/
	public boolean isEmpty();
	
	/**
		Clears all items in the list.
	*/
	public void clear();
}