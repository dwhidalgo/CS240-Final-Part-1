/**
	A quick sort algorithm that uses iteration to
	sort an array from low numbers to high numbers.
	@author Drue Hidalgo
*/

import java.util.Random;

public class QuickIterative
{
	public static void main(String[] args) throws EmptyQueueException
	{
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		int[] array = new int[10];
		
		Random randomObj = new Random();
		
		for (int q = 0; q < array.length; q++)
		{
			array[q] = randomObj.nextInt(1000);
			System.out.print(array[q] + " ");
		}
		
		System.out.println();
		
		int leftPointer = 0;
		int rightPointer = array.length - 1;
		boolean finishedSorting = false;
		int pivotPoint;
		int pivot;
		int index;
		
		while (!finishedSorting)
		{
			pivot = array[rightPointer];
			index = leftPointer - 1;
		
			for (int q = leftPointer; q < rightPointer; q++)
			{
				if (array[q] <= pivot)
				{
					index++;
				
					int temp = array[index];
					array[index] = array[q];
					array[q] = temp;
				}
			}
			
			pivotPoint = index + 1;
			array[rightPointer] = array[index + 1];
			array[index + 1] = pivot;

			
			queue.enqueue(leftPointer); 
			queue.enqueue(pivotPoint - 1);
			queue.enqueue(pivotPoint + 1); 
			queue.enqueue(rightPointer);
			

			do
			{
				if (queue.isEmpty()) 
				{
					finishedSorting = true;
				}
				else	
				{
					leftPointer = queue.dequeue();
					rightPointer = queue.dequeue();
				}
			}
			while (leftPointer >= rightPointer && !finishedSorting); 
		}
		
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
}