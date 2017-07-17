package com.metacube.pf.Question1;

import com.metacube.pf.PyramidMirror;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
/**
 *
 * @author Gaurav
 */
public class PatternBuilderTest {
    /**
     * Test of patternBuilder method, of class PyramidMirror.
     */
    @Test
    public void testPatternBuilder() {
        //Positive Test Case
        int row = 2;
        int n = 5;
        PyramidMirror instance = new PyramidMirror();
        String result = instance.patternBuilder(row, n);   
        String expected = "   121\n";
        assertEquals(expected, result);
        
        //Negative Test Case
        result = instance.patternBuilder(row, n);
        expected = "12321\n";
        assertNotEquals(expected, result); 
    } 
}
