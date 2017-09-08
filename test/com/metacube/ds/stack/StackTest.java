/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.stack;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class StackTest {

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        Object element = 1;
        Stack instance = new Stack();
        instance.push(element);
        assertEquals(element, instance.peek());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPop() {
        Stack instance = new Stack();
        instance.push(1);
        instance.push(2);
        instance.push(3);
        Object expResult = 3;
        Object result = instance.pop();
        assertEquals(expResult, result);
        
        expResult = 2;
        result = instance.pop();
        assertEquals(expResult, result);
        
        instance.pop();
        instance.pop();

    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        Stack instance = new Stack();
        instance.push(1);
        instance.push(2);
        instance.push(3);
        Object expResult = 3;
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
}
