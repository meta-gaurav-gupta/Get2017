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
public class TestSpaces {
    /**
     * Test of spaces method, of class Pyramid2.
     */
    @Test
    public void testSpaces() {
        System.out.println("spaces");
        int row = 2;
        int n = 5;
        Pyramid2 instance = new Pyramid2();
        String expResult = "   ";
        String result = instance.spaces(row, n);
        assertEquals(expResult, result);                                        //Positive Test Case
        expResult = "  ";
        result = instance.spaces(row, n);
        assertNotEquals(expResult, result);                                     //Negative Test Case
    }   
}
