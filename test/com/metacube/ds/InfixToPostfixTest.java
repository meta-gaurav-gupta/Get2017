package com.metacube.ds;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class InfixToPostfixTest {

    /**
     * Test of toPostfix method, of class InfixToPostfix.
     */
    @Test
    public void testToPostfix() {
        String infix = "A*(B+C*D)+E";
        InfixToPostfix instance = new InfixToPostfix();
        String expResult = "ABCD*+*E+";
        String result = instance.toPostfix(infix);
        assertEquals(expResult, result);
    }
    
}
