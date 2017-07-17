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
public class TestSpaces {
    /**
     * Test of spaces method, of class PyramidMirror.
     */
    @Test
    public void testSpaces() {
        int row = 2;
        int n = 5;
        PyramidMirror instance = new PyramidMirror();
        String expResult = "   ";
        String result = instance.spaces(row, n);
        assertEquals(expResult, result);                                        //Positive Test Case
        expResult = " ";
        result = instance.spaces(row, n);
        assertNotEquals(expResult, result);                                     //Negative Test Case
    }
}
