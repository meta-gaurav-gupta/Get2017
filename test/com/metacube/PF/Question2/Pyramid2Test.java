package com.metacube.PF.Question2;

import com.metacube.PF.Pyramid2;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class Pyramid2Test {
    /**
     * Test of pyramid method, of class Pyramid2.
     */
    @Test
    public void testPyramid() {
        int n = 3;
        Pyramid2 instance = new Pyramid2();
        String expResult = "123\n"
                            + " 12\n"
                            + "  1";
        String result = instance.pyramid(n);
        assertEquals(expResult, result);                                        //Positive Test Case
        n = 2;
        expResult = "12\n"
                    + "1\n";
        result = instance.pyramid(n);
        assertNotEquals(expResult, result);                                     //Negative Test Case
    }    
}
