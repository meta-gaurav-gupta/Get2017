/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.assignment2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class MyQueueTest {

    /**
     * Test of dequeue method, of class MyQueue.
     */
    @Test
    public void testDequeue() {
        MyQueue queue = new MyQueue();
        Object expResult = null;
        Object result = queue.dequeue();
        assertEquals(expResult, result);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        expResult = 1;
        result = queue.dequeue();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class MyQueue.
     */
    @Test
    public void testPeek() {
        MyQueue queue = new MyQueue();
        Object expResult = null;
        Object result = queue.peek();
        assertEquals(expResult, result);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        expResult = 1;
        result = queue.peek();
        assertEquals(expResult, result);
    }
    
}
