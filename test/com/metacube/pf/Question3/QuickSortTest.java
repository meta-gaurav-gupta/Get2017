package com.metacube.pf.Question3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class QuickSortTest {
    /**
     * Test of quickSort method, of class QuickSort.
     */
    @Test
    public void testQuickSort() {
        
        //Positive Test Case
        int[] input = {9, 6, 2, 8, 1, 7, 6};
        int indexOfLower = 0;
        int indexOfUpper = input.length - 1;
        QuickSort instance = new QuickSort();
        int[] expResult = {1, 2, 6, 6, 7, 8, 9};
        int[] result = instance.quickSort(input, indexOfLower, indexOfUpper);
        assertArrayEquals(expResult, result);
        
        //Negative Test Case
        expResult = new int[]{1, 2, 6, 6, 7, 8, 1}; 
        result = instance.quickSort(input, indexOfLower, indexOfUpper);
        assertNotEquals(expResult, result);
    }
}
