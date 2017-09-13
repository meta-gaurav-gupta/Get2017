/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class BinarySearchTest {

    /**
     * Test of binarySearch method, of class BinarySearch.
     */
    @Test
    public void testBinarySearch() {
        int[] input = new int[5];
        input[0] = 40;
        input[1] = 20;
        input[2] = 20;
        input[3] = 30;
        input[4] = 10;
        
        int searchItem = 20;
        BinarySearch object = new BinarySearch();
        int expResult = 1;
        int result = object.binarySearch(input, searchItem);
        assertEquals(expResult, result);
        
        searchItem = 100;
        expResult = -1;
        result = object.binarySearch(input, searchItem);
        assertEquals(expResult, result);
    }
    
}
