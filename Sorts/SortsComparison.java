// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Jerzy Jaskuc
 *  @version HT 2019
 */

 class SortsComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	double tmp;
    	for(int i=1; i<a.length; i++)
    	{
    		tmp = a[i];
    		boolean isInserted = false;
    		for(int j=i-1;j>=0 && !isInserted;j--)
    		{
    			if(tmp < a[j])
    			{
    				a[j+1] = a[j];
    			}
    			else
    			{
    				a[j+1] = tmp;
    				isInserted = true; // if inserted, exit
    			}
    		}
    		if(!isInserted)
    			a[0] = tmp; 		
    	}
    	return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
		 //TODO: implement the sort

    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	
    	   	
    	for(int sizeOfArray =1; sizeOfArray<a.length; sizeOfArray *= 2)
    	{
    		double mergedArray[] = new double[a.length];
    		int mergedArrayIndex = 0;
    		
    		while(mergedArrayIndex < mergedArray.length)
    		{
    			int leftArrayIndex = mergedArrayIndex;
    			int rightArrayIndex = leftArrayIndex+sizeOfArray;
    			int leftArrayStop = min(rightArrayIndex,mergedArray.length);
    			int rightArrayStop = min(rightArrayIndex+sizeOfArray, mergedArray.length);
    			// merge arrays
    			while(leftArrayIndex<leftArrayStop && rightArrayIndex<rightArrayStop)
    			{
    				if(a[leftArrayIndex]>a[rightArrayIndex])
    					mergedArray[mergedArrayIndex++] = a[rightArrayIndex++];
    				else
    					mergedArray[mergedArrayIndex++] = a[leftArrayIndex++];
    			}
    	    	// put the elements into merged array from left if any left
    	    	while(leftArrayIndex<leftArrayStop)
    	    	{
    	    		mergedArray[mergedArrayIndex++] = a[leftArrayIndex++];
    	    	}
    	    	// put the elements into merged array from right if any left
    	    	while(rightArrayIndex<rightArrayStop)
    	    	{
					mergedArray[mergedArrayIndex++] = a[rightArrayIndex++];
    	    	}	
    			
    		}
    		a = mergedArray;
    	}
    	
    	return a;
	
    }//end mergesortIterative
    
    private static int min(int a, int b)
    {
    	return a>b?b:a;
    }
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	if(a.length<=1)
    		return a;
    	int indexOfHalf = a.length/2;
    	double leftPart[] = mergeSortRecursion(a,0,indexOfHalf-1);
    	double rightPart[] = mergeSortRecursion(a,indexOfHalf,a.length-1);
    	
    	double mergedArray[] = new double[leftPart.length+rightPart.length];
    	int mergedArrayIndex = 0;
    	int leftCounter = 0;
    	int rightCounter = 0;
    	//merge arrays
    	while(leftCounter<leftPart.length && rightCounter<rightPart.length)
    	{
    		if(rightPart[rightCounter]<leftPart[leftCounter])
    			mergedArray[mergedArrayIndex++] = rightPart[rightCounter++]; // if right is less put it in merged array and post-incerement indexes
    		else
    			mergedArray[mergedArrayIndex++] = leftPart[leftCounter++]; // similiar if left is less
    	}
    	// put the elements into merged array from left if any left
    	while(leftCounter<leftPart.length)
    	{
    		mergedArray[mergedArrayIndex++] = leftPart[leftCounter++];
    	}
    	// put the elements into merged array from right if any left
    	while(rightCounter<rightPart.length)
    	{
    		mergedArray[mergedArrayIndex++] = rightPart[rightCounter++];
    	}
    	
    	return mergedArray;

	
   }//end mergeSortRecursive
    // recursive method for merge sort
    static private double[] mergeSortRecursion(double a[], int start, int finish){
    	if(finish-start<1)
    	{
    		double[] mergedArray = new double[1];
    		mergedArray[0] = a[start];
    		return mergedArray;
    	}
    	int indexOfHalf = start+(finish-start)/2; 
    	double leftPart[] = mergeSortRecursion(a,start,indexOfHalf);
    	double rightPart[] = mergeSortRecursion(a,indexOfHalf+1,finish);
    	
    	double mergedArray[] = new double[leftPart.length+rightPart.length];
    	int mergedArrayIndex = 0;
    	int leftCounter = 0;
    	int rightCounter = 0;
    	//merge arrays
    	while(leftCounter<leftPart.length && rightCounter<rightPart.length)
    	{
    		if(rightPart[rightCounter]<leftPart[leftCounter])
    			mergedArray[mergedArrayIndex++] = rightPart[rightCounter++]; // if right is less put it in merged array and post-incerement indexes
    		else
    			mergedArray[mergedArrayIndex++] = leftPart[leftCounter++]; // similiar if left is less
    	}
    	// put the elements into merged array from left if any left
    	while(leftCounter<leftPart.length)
    	{
    		mergedArray[mergedArrayIndex++] = leftPart[leftCounter++];
    	}
    	// put the elements into merged array from right if any left
    	while(rightCounter<rightPart.length)
    	{
    		mergedArray[mergedArrayIndex++] = rightPart[rightCounter++];
    	}
    	
    	return mergedArray;    	
    }
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

         for(int i=0;i<a.length;i++)
         {
        	 double tmp = a[i];
        	 int lowest = i;
        	 for(int j=i+1;j<a.length;j++)
        	 {
        		 if(a[j]<tmp)
        			 lowest = j;
        	 }
        	 if(lowest != i) 
        	 {
        		 a[i] = a[lowest];
        		 a[lowest] = tmp;
        	 }        	 
         }
         return a;

    }//end selectionsort

   


    public static void main(String[] args) {

        //TODO: do experiments as per assignment instructions
    }

 }//end class
