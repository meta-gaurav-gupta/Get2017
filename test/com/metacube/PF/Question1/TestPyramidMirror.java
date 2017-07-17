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
        String expString = 
                        "  1\n"
                    + " 121\n"
                    +"12321\n"
                    +" 121\n"
                    +"  1";
        String[] expResult = expString.split("\n");
        String[] result = instance.displayPyramid(n);
        assertArrayEquals(expResult, result);            
        
        //Negative Test Case 
        expString = 
                        "  1"
                    + " 121"
                    +"12321"
                    +"1234321"
                    +"12321"
                    +" 121"
                    +"  1";
        n = 4;
        expResult = expString.split("\n");
        result = instance.displayPyramid(n);
        assertNotEquals(expResult, result);                              
    }    
}
