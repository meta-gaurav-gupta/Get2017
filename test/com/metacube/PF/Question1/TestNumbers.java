package com.metacube.PF.Question1;

import com.metacube.PF.PyramidMirror;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author Gaurav
 */
public class TestNumbers {
    /**
     * Test of numbers method, of class PyramidMirror.
     */
    @Test
    public void testNumbers() {
        //Positive Test Case
        int row = 2;
        int n = 5;
        PyramidMirror instance = new PyramidMirror();
        String expResult = "121";
        String result = instance.numbers(row, n);
        assertEquals(expResult, result);        
        
        //Negative Test Case
        expResult = "12321";
        result = instance.numbers(row, n);
        assertNotEquals(expResult, result);                                     
    }
}
