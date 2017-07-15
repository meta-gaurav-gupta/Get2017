package com.metacube.PF;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.metacube.PF.MergeArray;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class MergeArrayTest {
    
     /**
     * Test of join method, of class MergeArray.
     */
    @Test
    public void testJoin() {
        System.out.println("join");
        int[] a = {1,3,6,8,10};
        int asize = 5;
        int[] b = {2,4,7,10};
        int bsize = 4;
        int[] c = new int[9];
        MergeArray instance = new MergeArray();
        int[] expResult = {1,2,3,4,6,7,8,10,10};
        int[] result = instance.join(a, asize, b, bsize, c);
        assertArrayEquals(expResult, result);                       //Positive Test Case
    }

    /**
     * Test of reverseArray method, of class MergeArray.
     */
    @Test
    public void testReverseArray() {
        System.out.println("reverseArray");
        int[] a = {2,4,7,10};
        MergeArray instance = new MergeArray();
        int[] expResult = {10,7,4,2};
        int[] result = instance.reverseArray(a);
        assertArrayEquals(expResult, result);                       //Positive Test Case
    }

    /**
     * Test of checkSortedOrder method, of class MergeArray.
     */
    @Test
    public void testCheckSortedOrder() {
        System.out.println("checkSortedOrder");
        int[] a = {7,56,65,74,82,91};
        MergeArray instance = new MergeArray();
        int expResult = 1;
        int result = instance.checkSortedOrder(a);
        assertEquals(expResult, result);                            //Positive Test Case
    }
    
}
