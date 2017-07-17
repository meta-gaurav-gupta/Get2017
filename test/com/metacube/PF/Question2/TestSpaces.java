package com.metacube.PF.Question2;

import com.metacube.PF.Pyramid2;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Gaurav
 */
public class TestSpaces {
    /**
     * Test of spaces method, of class Pyramid2.
     */
    @Test
    public void testSpaces() {
        //Positive Test Case
        int row = 2;
        int n = 5;
        Pyramid2 instance = new Pyramid2();
        String expResult = "   ";
        String result = instance.spaces(row, n);
        assertEquals(expResult, result);       
        
        //Negative Test Case
        expResult = "  ";
        result = instance.spaces(row, n);
        assertNotEquals(expResult, result);                                     
    }   
}
