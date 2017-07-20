package com.metacube.pf.Question3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class PartitioningTest {
    /**
     * Test of partitioning method, of class QuickSort.
     */
    @Test
    public void testPartitioning() {
        
        //Positive Test Case
        int[] input = {9, 6, 2, 8, 1, 7, 6};
        int indexOfLower = 0;
        int indexOfUpper = input.length - 1;
        QuickSort instance = new QuickSort();
        int expResult = 3;
        int result = instance.partitioning(input, indexOfLower, indexOfUpper);
        assertEquals(expResult, result);
        
        //Negative Test Case
        expResult = 4; 
        result = instance.partitioning(input, indexOfLower, indexOfUpper);
        assertNotEquals(expResult, result);
    }
}
