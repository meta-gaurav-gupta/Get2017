/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.PF.Question1;

import com.metacube.PF.PyramidMirror;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author User
 */
public class TestNumbers {
    /**
     * Test of numbers method, of class PyramidMirror.
     */
    @Test
    public void testNumbers() {
        int row = 2;
        int n = 5;
        PyramidMirror instance = new PyramidMirror();
        String expResult = "121";
        String result = instance.numbers(row, n);
        assertEquals(expResult, result);                                        //Positive Test Case
        expResult = "12321";
        result = instance.numbers(row, n);
        assertNotEquals(expResult, result);                                     //Negative Test Case
    }
}
