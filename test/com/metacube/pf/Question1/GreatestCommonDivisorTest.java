package com.metacube.pf.Question1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class GreatestCommonDivisorTest {

    /**
     * Test of calculateGcd method, of class GreatestCommonDivisor.
     */
    @Test
    public void testCalculateGcd() {
        GreatestCommonDivisor instance = new GreatestCommonDivisor();
        
        //Positive Test Case
        int expResult = 15;
        int result = instance.calculateGcd(-30, 15);
        assertEquals(expResult, result);
        
        //Negative Test Case
        result = instance.calculateGcd(6, 7);
        expResult = 6;
        assertNotEquals(expResult, result);
    }
    
}
