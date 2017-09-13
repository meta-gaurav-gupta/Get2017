/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.assignment1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class UniqueCharactersTest {

    /**
     * Test of getUniqueCharacters method, of class UniqueCharacters.
     */
    @Test
    public void testGetUniqueCharacters() {
        String string = "hello world";
        UniqueCharacters instance = new UniqueCharacters();
        int expResult = 7;
        int result = instance.getUniqueCharacters(string);
        assertEquals(expResult, result);
    }
    
}
