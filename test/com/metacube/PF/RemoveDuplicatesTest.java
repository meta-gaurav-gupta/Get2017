package com.metacube.PF;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.metacube.PF.RemoveDuplicates;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class RemoveDuplicatesTest {
    
    /**
     * Test of removeDuplicate method, of class RemoveDuplicates.
     */
    @Test
    public void testRemoveDuplicate() {
        System.out.println("removeDuplicate");
        int[] input_p = {1,2,3,4,2,5,3,6,3,1,1,1,1,1,1};
        int[] input_f = {7,8,0,2,1,1,2,8,3,3,4};
        RemoveDuplicates instance = new RemoveDuplicates();
        int[] expResult_p = {1,2,3,4,5,6};
        int[] result = instance.removeDuplicate(input_p);
        assertArrayEquals(expResult_p, result);                     //Positive Test Case
        result = instance.removeDuplicate(input_f);
        assertNotEquals(expResult_p, result);                       //Negative Test Case
    }

    /**
     * Test of elementExists method, of class RemoveDuplicates.
     */
    @Test
    public void testElementExists() {
        System.out.println("elementExists");
        int element_positive = 5;
        int element_negative = 0;
        int[] input_positive = {1,2,3,4,2,5,3,6,3,1,1,1,1,1,1};
        int[] input_negative = {2,3,5,2,5,7,6,3,5,1,8,2,1,4};
        RemoveDuplicates instance = new RemoveDuplicates();
        boolean expResult = true;
        boolean result = instance.elementExists(element_positive, input_positive);
        assertEquals(expResult, result);                            //Positive Test Case
        result = instance.elementExists(element_negative, input_negative);
        assertNotEquals(expResult, result);                         //Negative Test Case
    }
    
}
