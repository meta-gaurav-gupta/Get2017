package com.metacube.PF.Question1;

import com.metacube.PF.PyramidMirror;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class TestPyramidMirror {
    /**
     * Test of pyramid method, of class PyramidMirror.
     */
    @Test
    public void testPyramid() {
        //Positive Test Case
        int n = 3;
        PyramidMirror instance = new PyramidMirror();
        String expResult = 
                        "  1\n"
                    + " 121\n"
                    +"12321\n"
                    +" 121\n"
                    +"  1";
        String result = instance.displayPyramid(n);
        assertEquals(expResult, result);            
        
        //Negative Test Case 
        expResult = "  1"
                    + " 121"
                    +"12321"
                    +"1234321"
                    +"12321"
                    +" 121"
                    +"  1";
        n = 4;
        result = instance.displayPyramid(n);
        assertNotEquals(expResult, result);                                     
    }    
}
