package com.metacube.pf.Question2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class LinearSearchTest {
    /**
     * Test of linearSearch method, of class LinearSearch.
     */
    @Test
    public void testLinearSearch() {
        //Positive Test Case
        int[] input = {1, 3, 6, 8, 9, 10};
        int search = 3;
        int indexOfLower = 0;
        int indexOfUpper = 5;
        BinarySearch instance = new BinarySearch();
        int expResult = 1;
        int result = instance.binarySearch(input, search, indexOfLower, indexOfUpper);
        assertEquals(expResult, result);
        
        //Positive Test Case
        search = 11;
	result = instance.binarySearch(input, search, indexOfLower, indexOfUpper);
	expResult = -1;
	assertEquals(expResult, result);
        
        //Negative Test Case
        input = new int[]{1, 3, 4, 5, 7, 9};
        indexOfLower = 0;
        indexOfUpper = 5;
        search = 3;
        result = instance.binarySearch(input, search, indexOfLower, indexOfUpper);
        expResult = -1;
        assertNotEquals(expResult, result);
        
        //Negative Test Case
        search = 11;
        result = instance.binarySearch(input, search, indexOfLower, indexOfUpper);
        expResult = 5;
        assertNotEquals(expResult, result);
    }
    
}
