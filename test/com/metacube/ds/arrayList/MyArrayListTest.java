package com.metacube.ds.arrayList;

import com.metacube.ds.Utility;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class MyArrayListTest {
    
    /**
     * Test of indexOf method, of class MyArrayList.
     */
    @Test
    public void testIndexOf() {
        //Positive Test Case
        Object obj = 5;
        MyArrayList<Integer> list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int expResult = 4;
        int result = list.indexOf(obj);
        assertEquals(expResult, result);
        
        //Negative Test Case
        obj = "abc";
        expResult = -1;
        result = list.indexOf(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class MyArrayList.
     */
    @Test
    public void testAdd_GenericType() {
        Integer data = 5;
        MyArrayList<Integer> list = new MyArrayList();
        boolean expResult = true;
        boolean result = list.add(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class DoublyLinkedList.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_AtIndex() {
        //Positive Test Case
        int data = 1;
        int index = 0;
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(index, data);
        
        //Negative Test Case (throws IndexOutOfBoundsException)
        index = -1;
        data = 10;
        list.add(index, data);
    }
    
    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove_int() {
        int index = 2;
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
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
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemove_Object() {
        Object obj = 5;
        MyArrayList list = new MyArrayList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
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
     * Test of sort method.
     */
    @Test
    public void testSort() {
        MyArrayList list = new MyArrayList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        MyArrayList listTemp = new MyArrayList();
        listTemp.addAll(list);
        Object[] obj = listTemp.toArray();
        Arrays.sort(obj);
        Utility.sort(list);
        assertArrayEquals(obj, list.toArray());
    }

    /**
     * Test of get method, of class MyArrayList.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() {
        //Positive Test Case
        int index = 1;
        MyArrayList list = new MyArrayList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        Object expResult = 4;
        Object result = list.get(index);
        assertEquals(expResult, result);
        
        //Negative Test Case (throws IndexOutOfBoundsException)
        index = 10;
        expResult = -1;
        result = list.get(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAll method, of class MyArrayList.
     */
    @Test(expected = NullPointerException.class)
    public void testAddAll() {
        MyArrayList list1 = new MyArrayList();
        MyArrayList list2 = new MyArrayList();
        list1.add(10);
        list1.add(20);
        list2.add(30);
        list2.add(40);
        boolean expResult = true;
        boolean result = list1.addAll(list2);
        assertEquals(expResult, result);
        
        //Negative Test Case (throws NullPointerException)
        MyArrayList list3 = null;
        expResult = false;
        result = list1.addAll(list3);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of reverse method.
     */
    @Test
    public void testReverse() {
        MyArrayList list = new MyArrayList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        MyArrayList listTemp = new MyArrayList();
        listTemp.addAll(list);
        Object[] obj = listTemp.toArray();
        Collections.reverse(Arrays.asList(obj));
        Utility.reverse(list);
        Object[] result = list.toArray();
        assertArrayEquals(obj, result);
    }
    
}
