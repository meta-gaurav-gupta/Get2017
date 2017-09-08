/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.queue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class QueueTest {

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Object expResult = 1;
        Object result = queue.dequeue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFront method, of class Queue.
     */
    @Test
    public void testGetFront() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Object expResult = 1;
        Object result = queue.getFront();
        assertEquals(expResult, result);
    }
    
}
