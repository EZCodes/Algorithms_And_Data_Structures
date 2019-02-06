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
 *  @author
 *  @version HT 2019
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
    }
    @Test
    public void testSorts()
    {
    	    	    	
    	double a[] = {21.67,5.43,10, 8.94,19.54};
    	double b[] = {21.67,5.43, 8.94, 10,19.54};
    	double c[] = {21.67,10,5.43, 8.94,19.54};
    	double d[] = {21.67,19.54, 5.43,10, 8.94};
    	double e[] = {5.43,10,21.67, 8.94,19.54};
    	double sorted[] = {5.43, 8.94,10,19.54,21.67};
    	assertArrayEquals(sorted,SortsComparison.insertionSort(a));
    	assertArrayEquals(sorted,SortsComparison.selectionSort(b));
    	assertArrayEquals(sorted,SortsComparison.mergeSortRecursive(c));
    	assertArrayEquals(sorted,SortsComparison.mergeSortIterative(d));
    	assertArrayEquals(sorted,SortsComparison.quickSort(e));
    	  	
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
    		long startTime;
    		long endTime;
			double num10[] = makeArray(in, 10);
			startTime = System.nanoTime();
			SortsComparison.selectionSort(num10);
			endTime = System.nanoTime();
			System.out.println("Selection 10 elements: "+((endTime - startTime)/1000000));
			// test
			in = new BufferedReader(new FileReader(numbers100));
			double num100[] = makeArray(in, 10);
			// test
			in = new BufferedReader(new FileReader(numbers1000));
			double num1000[] = makeArray(in, 10);
			// test
			in = new BufferedReader(new FileReader(numbers1000Duplicates));
			double num1000Dup[] = makeArray(in, 10);
			// test
			in = new BufferedReader(new FileReader(numbersNearlyOrdered1000));
			double num1000Nearly[] = makeArray(in, 10);
			// test
			in = new BufferedReader(new FileReader(numbersReverse1000));
			double num1000Rev[] = makeArray(in, 10);
			// test
			in = new BufferedReader(new FileReader(numbersSorted1000));
			double num1000Sorted[] = makeArray(in, 10);
			// test
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

}
