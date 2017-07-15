package com.metacube.PF;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.metacube.PF.CheckSorted;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CheckSortedTest {
    
    /**
     * Test of checkSort method, of class CheckSorted.
     */
    @Test
    public void testCheckSort() {
        System.out.println("checkSort");
        int[] input_positive = {7,56,65,74,82,91};
        int[] input_negative = {91,82,74,65,56,7};
        CheckSorted instance = new CheckSorted();
        int expResult = 1;
        int result = instance.checkSort(input_positive);
        assertEquals(expResult, result);                                        //Positive Test Case
        result = instance.checkSort(input_negative);
        assertNotEquals(expResult, result);                                     //Negative Test Case
    }
    
}
