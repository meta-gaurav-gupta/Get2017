package com.metacube.PF.Question1;

import com.metacube.PF.PyramidMirror;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author Gaurav
 */
public class TestSpaces {
    /**
     * Test of spaces method, of class PyramidMirror.
     */
    @Test
    public void testSpaces() {
        //Positive Test Case
        int row = 2;
        int n = 5;
        PyramidMirror instance = new PyramidMirror();
        String expResult = "   ";
        String result = instance.spaces(row, n);
        assertEquals(expResult, result);  
        
        //Negative Test Case
        expResult = " ";
        result = instance.spaces(row, n);
        assertNotEquals(expResult, result);                                     
    }
}
