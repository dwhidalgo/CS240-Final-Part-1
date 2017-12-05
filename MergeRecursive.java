import java.util.Random;

/**
	A recursive implementation of the merge sort algorithm.
	@author Drue Hidalgo
 */
public class MergeRecursive
{
    public static void sort(int[] array, int first, int last)
	{
		if (first < last) 
		{
			int midpoint = (first + last)/2;
			sort(array, first, midpoint); 
			sort(array, midpoint+1, last); 
			merge(array, first, midpoint, last); 
		}
	}
        
    public static void merge(int[] array, int first, int mid, int last)
    {
        int[] firstArray = new int[mid - first + 1];
        int[] lastArray = new int[last - mid]; 
        
        for (int i=0; i < mid-first+1; i++)
        {
            firstArray[i] = array[first + i]; 
        }
        for (int i=0; i < last-mid; i++)
        {
            lastArray[i] = array[mid+1 + i];
        }
        
        int i = 0; 
        int j = 0; 
        int k = first;
        while (i < firstArray.length && j < lastArray.length)
        {
            if (firstArray[i] < lastArray[j])
            {
                array[k] = firstArray[i];
                i++;
            }
            else
            {
                array[k] = lastArray[j]; 
                j++;
            }
            k++;
        }
       
        while (i < firstArray.length)
        {
            array[k] = firstArray[i];
            i++;
            k++;
        }
        while (j < lastArray.length) 
        {
            array[k] = lastArray[j];
            j++;
            k++;
        }
    }
}