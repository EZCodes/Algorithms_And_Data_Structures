import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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


   

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
