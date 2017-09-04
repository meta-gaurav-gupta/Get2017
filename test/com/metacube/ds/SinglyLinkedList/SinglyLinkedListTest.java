/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.SinglyLinkedList;

import com.metacube.ds.Utility;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class SinglyLinkedListTest {

    /**
     * Test of add method, of class SinglyLinkedList.
     */
    @Test
    public void testAdd_GenericType() {
        Object data = 1;
        SinglyLinkedList list = new SinglyLinkedList();
        boolean expResult = true;
        boolean result = list.add(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class SinglyLinkedList.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_AtIndex() {
        //Positive Test Case
        Object data = 1;
        int index = 0;
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(index, data);
        
        //Negative Test Case (throws IndexOutOfBoundsException)
        index = -1;
        data = 10;
        list.add(index, data);
    }
    
    /**
     * Test of remove method, of class SinglyLinkedList.
     */
    @Test
    public void testRemove_Object() {
        //Positive Test Case
        Object obj = 2;
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        boolean expResult = true;
        boolean result = list.remove(obj);
        assertEquals(expResult, result);
        
        //Negative Test Case
        obj = 10;
        expResult = false;
        result = list.remove(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of remove method, of class SinglyLinkedList.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove_int() {
        //Positive Test Case
        int index = 2;
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Object expResult = 3;
        Object result = list.remove(index);
        assertEquals(expResult, result);
        
        //Negative Test Case (throws IndexOutOfBoundsException)
        index = 10;
        expResult = -1;
        result = list.remove(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class SinglyLinkedList.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() {
        //Positive Test Case
        int index = 4;
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Object expResult = 5;
        Object result = list.get(index);
        assertEquals(expResult, result);
        
        //Negative Test Case (throws IndexOutOfBoundsException)
        index = 10;
        expResult = -1;
        result = list.get(index);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sort method.
     */
    @Test
    public void testSort() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        SinglyLinkedList listTemp = list;
        Object[] obj = listTemp.toArray();
        Arrays.sort(obj);
        Utility.sort(list);
        assertArrayEquals(obj, list.toArray());
    }
    
    /**
     * Test of reverse method.
     */
    @Test
    public void testReverse() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        SinglyLinkedList listTemp = list;
        Object[] obj = listTemp.toArray();
        Collections.reverse(Arrays.asList(obj));
        Utility.reverse(list);
        Object[] result = list.toArray();
        assertArrayEquals(obj, result);
    }
}
