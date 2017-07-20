package com.metacube.pf.Question1;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class LargestDigitTest {
    
    /**
     * Test of largestDigit method, of class LargestDigit.
     */
    @Test
    public void testLargestDigit() {
        
        //Positive Test Case
        LargestDigit instance = new LargestDigit();
        int x = 12345;
        int expResult = 5;
        int result = instance.largestDigit(x);
        assertEquals(expResult, result);
        
        //Negative Test Case
        x = -300023;
        result = instance.largestDigit(x);
	expResult = 6;
	assertNotEquals(expResult, result);
    }
    
}
