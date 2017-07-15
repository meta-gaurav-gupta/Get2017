package com.metacube.PF;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author Gaurav
 */
public class BinaryToOctalTest {

     /**
     * Test of convertBinaryToOctal method, of class BinaryToOctal.
     */
    @Test
    public void testConvertBinaryToOctal() {
        System.out.println("convertBinaryToOctal");
        BinaryToOctal instance = new BinaryToOctal();
        int result = instance.convertBinaryToOctal(110101);
        assertEquals(65, result);                                       //Positive Test Case
        result = instance.convertBinaryToOctal(11);
        assertEquals(3, result);                                        //Positive Test Case
        result = instance.convertBinaryToOctal(110110);
        assertNotEquals(0, result);                                     //Negative Test Case
    }

    /**
     * Test of convertBinaryToDecimal method, of class BinaryToOctal.
     */
    @Test
    public void testConvertBinaryToDecimal() {
        System.out.println("convertBinaryToDecimal");
        BinaryToOctal instance = new BinaryToOctal();
        int result = instance.convertBinaryToDecimal(110101);
        assertEquals(53, result);                                       //Positive Test Case
        result = instance.convertBinaryToDecimal(011);
        assertNotEquals(0, result);                                     //Negative Test Case
    }

    /**
     * Test of convertDecimalToOctal method, of class BinaryToOctal.
     */
    @Test
    public void testConvertDecimalToOctal() {
        System.out.println("convertDecimalToOctal");
        BinaryToOctal instance = new BinaryToOctal();
        int result = instance.convertDecimalToOctal(53);
        assertEquals(65, result);                                       //Positive Test Case
        result = instance.convertDecimalToOctal(65);
        assertNotEquals(0, result);                                     //Negative Test Case
    }
    
}
