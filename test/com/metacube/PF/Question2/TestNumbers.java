/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.PF.Question2;

import com.metacube.PF.Pyramid2;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TestNumbers {
    
    /**
     * Test of numbers method, of class Pyramid2.
     */
    @Test
    public void testNumbers() {
        int row = 5;
        int n = 5;
        Pyramid2 instance = new Pyramid2();
        String expResult = "12345";
        String result = instance.numbers(row, n);
        assertEquals(expResult, result);                                        //Positive Test Case
        row = 2;
        n = 5;
        result = instance.numbers(row, n);   
        String expected="432";
        assertNotEquals(expected, result);                                      //Negative Test Case
    }
}
