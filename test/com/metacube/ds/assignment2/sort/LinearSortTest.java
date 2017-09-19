package com.metacube.ds.assignment2.sort;

import com.metacube.ds.assignment2.enums.SortType;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class LinearSortTest {

    /**
     * Test of sort method, of class LinearSort.
     */
    @Test
    public void testSort() {
        //Test case digits of number are less than 3 -> Counting sort is used
        int[] input1 = {2,3,8,7,1,2,2,9};
        LinearSort sort = new LinearSort();
        SortType expResult = SortType.COUNTING_SORT;
        SortType result = sort.sort(input1);
        assertEquals(expResult, result);
        
        //Positive Test case Counting sort 
        int[] output1 = {1, 2, 2, 2, 3, 7, 8, 9};
        assertArrayEquals(input1, output1);
        
        //Test case digits of number are more than 3 -> Radix sort is used
        int[] input2 = {321,54,452,8,157,78};
        expResult = SortType.RADIX_SORT;
        result = sort.sort(input2);
        assertEquals(expResult, result);
        
        //Positive Test case radix sort 
        int[] output2 = {8, 54, 78, 157, 321, 452};
        assertArrayEquals(input2, output2);
    }
    
}
