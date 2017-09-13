/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.assignment1;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CharacterOccurrenceTest {

    /**
     * Test of getOccurrence method, of class CharacterOccurrence.
     */
    @Test
    public void testGetOccurrence() {
        String string = "Hello World";
        CharacterOccurrence instance = new CharacterOccurrence();
        String expResult = "{r=[7], d=[9], e=[1], W=[5], H=[0], l=[2, 3, 8], o=[4, 6]}";
        Map<Character, List<Integer>> map = instance.getOccurrence(string);
        String result = map.toString();
        assertEquals(expResult, result);
    }
    
}
