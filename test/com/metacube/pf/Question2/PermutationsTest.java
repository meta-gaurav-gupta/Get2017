
package com.metacube.pf.Question2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class PermutationsTest {
    /**
     * Test of generatePermutations method, of class Permutations.
     */
    @Test
    public void testGeneratePermutations() {
        
        //Positive Test Case
        String inputString = "ABC";
        Permutations instance = new Permutations();
        List<String> expResult = new ArrayList<>();
        expResult.add("ABC");
        expResult.add("ACB");
        expResult.add("BAC");
        expResult.add("BCA");
        expResult.add("CBA");
        expResult.add("CAB");
        List<String> result = instance.generatePermutations(inputString);
        assertEquals(expResult, result);
        
        //Negative Test Case
        inputString = "";
        expResult = null;
        result = instance.generatePermutations(inputString);
        assertEquals(expResult, result);
    }
    
}
