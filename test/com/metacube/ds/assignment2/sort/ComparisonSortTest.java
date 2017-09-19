/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.assignment2.sort;

import com.metacube.ds.assignment2.enums.SortType;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ComparisonSortTest {

    /**
     * Test of sort method, of class ComparisonSort.
     */
    @Test
    public void testSort() {
        //Test case numbers are less than 10 -> Bubble sort is used
        int[] input1 = {3,44,38,5,47,15,36};
        ComparisonSort sort = new ComparisonSort();
        SortType expResult = SortType.BUBBLE_SORT;
        SortType result = sort.sort(input1);
        assertEquals(expResult, result);
        
        //Positive Test case bubble sort 
        int[] output1 = {3, 5, 15, 36, 38, 44, 47};
        assertArrayEquals(input1, output1);
        
        //Test case numbers are more than 10 -> Quick sort is used
        int[] input2 = {3,44,38,5,47,15,36,26,0,-23,1};
        expResult = SortType.QUICK_SORT;
        result = sort.sort(input2);
        assertEquals(expResult, result);
        
        //Positive Test case quick sort
        int[] output2 = {-23, 0, 1, 3, 5, 15, 26, 36, 38, 44, 47};
        assertArrayEquals(input2, output2);
    }
    
}
