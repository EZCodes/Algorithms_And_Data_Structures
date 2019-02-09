import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Jerzy Jaskuc
 *  @version HT 2019
 *  
 *  
 *   Running times of the sorts in nanoseconds:
 *						|Selection 	|Quick Sort  |Merge Recursive   |Merge Iterative |Insertion
 *	10 random			|547294		|458393	   	 |16410	 			|10940			 |4376
 *	100 random			|134565		|63088	  	 |48866	    		|28445			 |59441
 *	1000 random			|5433255	|1070314  	 |730439 			|647293			 |3893973
 *	1000 few unique 	|2181835	|516741	   	 |186712	    	|792069			 |1634098
 *	1000 nearly ordered	|326017		|245060	  	 |136023	    	|379624			 |337686
 *	1000 reverse order	|672456		|188171	  	 |113413	    	|603168			 |493867
 *	1000 sorted			|543362		|152797	  	 |109402	      	|279704			 |5470
 *
 *
 *	Questions answered:
 *		A. It had an impact on insertion sort because its shifting an element until it finds
 *		the element lower than it. Thats why the array is in reverse order it will be the worst case for insertion sort since it will
 *		backtrack through all elements before placing current element in right position.
 *		Other sort that can be impacted but order of array is quicksort, if it's always first pivot implementation, then sorted array would
 *		much longer time then normally shuffled array. However, i implemented random pivot and so this problem is mitigated.
 *		B. The biggest difference is for Insertion Sort, between shuffled 1000 element array and sorted one. 
 *		Thanks to how insertion sort works (described in A) its best performance is when array is sorted, and so it takes almost no time 
 *		to go through it.
 *		C. Worst scalable sorts are Insertion and Selection sorts. Best scalable sort out of all above is merge sort in both recursive
 *		and iterative implementation as they are more than 5 times more efficient than Selection or Insertion sorts at 1000 elements.
 *		However, they are a bit slower at low amount of elements like 10.
 *		Quick sort also scales extremely well and might even be better sometimes than Merge sorts. Since i implemented random pivot
 *		the excecution times of quicksort varies largely. The time in the table is the average out of all runs of quicksort.
 *		The quickest time was around half of the one in the table and slowest can reach double that time.
 *		D.Yes, Iterative works quicker than Recursive on random arrays. However when arrays contain duplicates or have specific orders
 *		then the recursive implementation wins the race.
 *		E.Considering the table above(where quick sort has random pivot)
 *		File 1. Insertion Sort.
 *		File 2. Merge Iterative
 *		File 3. Merge Iterative
 *		File 4. Merge Recursive
 *		File 5. Merge Recursive
 *		File 6. Merge Recursive
 *		File.7	Insertion Sort
 *
 *	Side note: as you can see selection sort took quicte a while for the first file. I noticed that whichever sort
 *	was tested first, it running time for the first file was quite big compared to the rest. I assume it had to do with the memory accesses
 *	and caching of neighbouring memory for the rest of the sorts.
 *
 *	I also used nanoseconds since in milliseconds most of the times were 0.
 *	
 */

@RunWith(JUnit4.class)
public class SortsComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortsComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double a[] = {};
    	
    	assertArrayEquals(a,SortsComparison.insertionSort(a));
    	assertArrayEquals(a,SortsComparison.selectionSort(a));
    	assertArrayEquals(a,SortsComparison.mergeSortRecursive(a));
    	assertArrayEquals(a,SortsComparison.mergeSortIterative(a));
    	assertArrayEquals(a,SortsComparison.quickSort(a));
    	assertArrayEquals(null,SortsComparison.insertionSort(null));
    	assertArrayEquals(null,SortsComparison.selectionSort(null));
    	assertArrayEquals(null,SortsComparison.mergeSortRecursive(null));
    	assertArrayEquals(null,SortsComparison.mergeSortIterative(null));
    	assertArrayEquals(null,SortsComparison.quickSort(null));
    	
    }
    @Test
    public void testSorts()
    {
    	    	    	
    	double a[] = {21.67,5.43,10, 8.94,19.54};
    	double b[] = {21.67,5.43, 8.94, 10,19.54};
    	double c[] = {21.67,10,5.43, 8.94,19.54};
    	double c2[] = {8.94,19.54,5.43,10,21.67};
    	double d[] = {21.67,19.54, 5.43,10, 8.94};
    	double e[] = {5.43,10,21.67, 8.94,19.54};
    	double sorted[] = {5.43, 8.94,10,19.54,21.67};
    	assertArrayEquals(sorted,SortsComparison.insertionSort(a));
    	assertArrayEquals(sorted,SortsComparison.selectionSort(b));
    	assertArrayEquals(sorted,SortsComparison.mergeSortRecursive(c));
    	assertArrayEquals(sorted,SortsComparison.mergeSortRecursive(c2));
    	assertArrayEquals(sorted,SortsComparison.mergeSortIterative(d));
    	
    	// need a couple of test for quicksort since it's random pivot, for good coverage
    	assertArrayEquals(sorted,SortsComparison.quickSort(e));
    	double[] e2 = {560.66,181.87,308.65,990.73,142.14,261.1,549.95,587.12,335.64,588.04,558.49,135.82,95.63,723.43,815.16};
    	double[] sortedE2 = {95.63,135.82,142.14,181.87,261.1,308.65,335.64,549.95,558.49,560.66,587.12,588.04,723.43,815.16,990.73};
    	assertArrayEquals(sortedE2,SortsComparison.quickSort(e2));
    	double[] e3 = {984.24,81.61,490.43,358.61,683.43,926.24,890.24,124.06,875.48,335.98};
    	double[] sortedE3 = {81.61,124.06,335.98,358.61,490.43,683.43,875.48,890.24,926.24,984.24};
    	assertArrayEquals(sortedE3,SortsComparison.quickSort(e3));
    	double d2[] = {21.67,19.54, 5.43,10, 8.94};
    	assertArrayEquals(sorted, SortsComparison.quickSort(d2));
    }

    private static double[] makeArray(BufferedReader in, int length) throws IOException
    {
    	double[] array = new double[length];
    	String number = in.readLine();
		int index = 0;
    	while(number != null && index<length) 
    	{
    		array[index++] = Double.parseDouble(number);
    		number = in.readLine();
    	}
    	return array;
    }
   

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *		

     */
    public static void main(String[] args)
    {
    	File numbers10 = new File("numbers10.txt");
    	File numbers100 = new File("numbers100.txt");
    	File numbers1000 = new File("numbers1000.txt");
    	File numbers1000Duplicates = new File("numbers1000Duplicates.txt");
    	File numbersNearlyOrdered1000 = new File("numbersNearlyOrdered1000.txt");
    	File numbersReverse1000 = new File("numbersReverse1000.txt");
    	File numbersSorted1000 = new File("numbersSorted1000.txt");
    	
    	
    	try {
    		BufferedReader in = new BufferedReader(new FileReader(numbers10));

    		
    		// testing selection Sort
			double num10[] = makeArray(in, 10);
			selectionSortTime(num10, "10 elements: ");
			
			in = new BufferedReader(new FileReader(numbers100));
			double num100[] = makeArray(in, 100);
			selectionSortTime(num100, "100 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000));
			double num1000[] = makeArray(in, 1000);
			selectionSortTime(num1000, "1000 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000Duplicates));
			double num1000Dup[] = makeArray(in, 1000);
			selectionSortTime(num1000Dup, "1000 elements with duplicates: ");

			in = new BufferedReader(new FileReader(numbersNearlyOrdered1000));
			double num1000Nearly[] = makeArray(in, 1000);
			selectionSortTime(num1000Nearly, "1000 elements nearly sorted: ");

			in = new BufferedReader(new FileReader(numbersReverse1000));
			double num1000Rev[] = makeArray(in, 1000);
			selectionSortTime(num1000Rev, "1000 elements reverse order: ");

			in = new BufferedReader(new FileReader(numbersSorted1000));
			double num1000Sorted[] = makeArray(in, 1000);
			selectionSortTime(num1000Sorted, "1000 elements sorted array: ");
			
			// testing InsertionSort
			num10 = makeArray(in, 10);
			insertionSortTime(num10, "10 elements: ");
			
			in = new BufferedReader(new FileReader(numbers100));
			num100 = makeArray(in, 100);
			insertionSortTime(num100, "100 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000));
			num1000 = makeArray(in, 1000);
			insertionSortTime(num1000, "1000 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000Duplicates));
			num1000Dup = makeArray(in, 1000);
			insertionSortTime(num1000Dup, "1000 elements with duplicates: ");

			in = new BufferedReader(new FileReader(numbersNearlyOrdered1000));
			num1000Nearly = makeArray(in, 1000);
			insertionSortTime(num1000Nearly, "1000 elements nearly sorted: ");

			in = new BufferedReader(new FileReader(numbersReverse1000));
			num1000Rev = makeArray(in, 1000);
			insertionSortTime(num1000Rev, "1000 elements reverse order: ");

			in = new BufferedReader(new FileReader(numbersSorted1000));
			num1000Sorted = makeArray(in, 1000);
			insertionSortTime(num1000Sorted, "1000 elements sorted array: ");
			
			// testing merge sort recursive times
			num10 = makeArray(in, 10);
			mergeSortRecursiveTime(num10, "10 elements: ");
			
			in = new BufferedReader(new FileReader(numbers100));
			num100 = makeArray(in, 100);
			mergeSortRecursiveTime(num100, "100 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000));
			num1000 = makeArray(in, 1000);
			mergeSortRecursiveTime(num1000, "1000 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000Duplicates));
			num1000Dup = makeArray(in, 1000);
			mergeSortRecursiveTime(num1000Dup, "1000 elements with duplicates: ");

			in = new BufferedReader(new FileReader(numbersNearlyOrdered1000));
			num1000Nearly = makeArray(in, 1000);
			mergeSortRecursiveTime(num1000Nearly, "1000 elements nearly sorted: ");

			in = new BufferedReader(new FileReader(numbersReverse1000));
			num1000Rev = makeArray(in, 1000);
			mergeSortRecursiveTime(num1000Rev, "1000 elements reverse order: ");

			in = new BufferedReader(new FileReader(numbersSorted1000));
			num1000Sorted = makeArray(in, 1000);
			mergeSortRecursiveTime(num1000Sorted, "1000 elements sorted array: ");
			
			// testing time of merge sort iterative
			num10 = makeArray(in, 10);
			mergeSortIterativeTime(num10, "10 elements: ");
			
			in = new BufferedReader(new FileReader(numbers100));
			num100 = makeArray(in, 100);
			mergeSortIterativeTime(num100, "100 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000));
			num1000 = makeArray(in, 1000);
			mergeSortIterativeTime(num1000, "1000 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000Duplicates));
			num1000Dup = makeArray(in, 1000);
			mergeSortIterativeTime(num1000Dup, "1000 elements with duplicates: ");

			in = new BufferedReader(new FileReader(numbersNearlyOrdered1000));
			num1000Nearly = makeArray(in, 1000);
			mergeSortIterativeTime(num1000Nearly, "1000 elements nearly sorted: ");

			in = new BufferedReader(new FileReader(numbersReverse1000));
			num1000Rev = makeArray(in, 1000);
			mergeSortIterativeTime(num1000Rev, "1000 elements reverse order: ");

			in = new BufferedReader(new FileReader(numbersSorted1000));
			num1000Sorted = makeArray(in, 1000);
			mergeSortIterativeTime(num1000Sorted, "1000 elements sorted array: ");
			
			// testing time of quick sort
			num10 = makeArray(in, 10);
			quickSortTime(num10, "10 elements: ");
			
			in = new BufferedReader(new FileReader(numbers100));
			num100 = makeArray(in, 100);
			quickSortTime(num100, "100 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000));
			num1000 = makeArray(in, 1000);
			quickSortTime(num1000, "1000 elements: ");
			
			in = new BufferedReader(new FileReader(numbers1000Duplicates));
			num1000Dup = makeArray(in, 1000);
			quickSortTime(num1000Dup, "1000 elements with duplicates: ");

			in = new BufferedReader(new FileReader(numbersNearlyOrdered1000));
			num1000Nearly = makeArray(in, 1000);
			quickSortTime(num1000Nearly, "1000 elements nearly sorted: ");

			in = new BufferedReader(new FileReader(numbersReverse1000));
			num1000Rev = makeArray(in, 1000);
			quickSortTime(num1000Rev, "1000 elements reverse order: ");

			in = new BufferedReader(new FileReader(numbersSorted1000));
			num1000Sorted = makeArray(in, 1000);
			quickSortTime(num1000Sorted, "1000 elements sorted array: ");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    private static void selectionSortTime(double[] array, String typeOfArray) {
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		SortsComparison.selectionSort(array);
		endTime = System.nanoTime();
		System.out.println("Selection sort "+typeOfArray +((endTime - startTime)) +" nanoseconds");
    }
    private static void insertionSortTime(double[] array, String typeOfArray) {
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		SortsComparison.insertionSort(array);
		endTime = System.nanoTime();
		System.out.println("Insertion sort "+typeOfArray +((endTime - startTime)) +" nanoseconds");
    }
    private static void mergeSortRecursiveTime(double[] array, String typeOfArray) {
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		SortsComparison.mergeSortRecursive(array);
		endTime = System.nanoTime();
		System.out.println("Merge recursive sort "+typeOfArray +((endTime - startTime)) +" nanoseconds");
    }
    private static void mergeSortIterativeTime(double[] array,String typeOfArray) {
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		SortsComparison.mergeSortIterative(array);
		endTime = System.nanoTime();
		System.out.println("Iterative merge sort "+typeOfArray +((endTime - startTime)) +" nanoseconds");
    }
    private static void quickSortTime(double[] array, String typeOfArray) {
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		SortsComparison.quickSort(array);
		endTime = System.nanoTime();
		System.out.println("Quick sort "+typeOfArray +((endTime - startTime)) +" nanoseconds");
    }

}
