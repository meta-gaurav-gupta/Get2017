package com.metacube.pf.Question1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav 
 */
public class RemainderTest {
    
    /**
     * Test of rem method, of class Remainder.
     */
    @Test
    public void testRem() {
        Remainder instance = new Remainder();
        
        //Positive Test Case
        int output = instance.rem(-5, 2);
        int expected = -1;
        assertEquals(expected, output);

        //Positive Test Case
        output = instance.rem(2, 1);
        expected = 0;
        assertEquals(expected, output); 
        
        //Negative Test Case
        output = instance.rem(2, 0);
        expected = 1;
        assertNotEquals(expected, output); 
        
        //Negative Test Case
        output = instance.rem(-5, 2);
	expected = 1;
        assertNotEquals(expected, output);
    }
}