package com.metacube.PF;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.metacube.PF.LongestIncreasingSequence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class LongestIncreasingSequenceTest {
    
    /**
     * Test of longestSequence method, of class LongestIncreasingSequence.
     */
    @Test
    public void testLongestSequence() {
        System.out.println("longestSequence");
        int[] input_positive = {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
        int[] input_negative = {1,3,2,4,2,5,9,2,7,2,5,9,9,6,4,2,1,2,4,6,8,9};
        LongestIncreasingSequence instance = new LongestIncreasingSequence();
        int[] expResult = {1,2,4,5,6,7,8,9};
        int[] result = instance.longestSequence(input_positive);
        assertArrayEquals(expResult, result);                           //Positive Test Case
        result = instance.longestSequence(input_negative);
        assertNotEquals(expResult, result);                             //Negative Test Case
    }
    
}
