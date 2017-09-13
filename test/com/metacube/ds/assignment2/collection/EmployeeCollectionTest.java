/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.assignment2.collection;

import com.metacube.ds.assignment2.entity.Employee;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class EmployeeCollectionTest {

    /**
     * Test of add method, of class EmployeeCollection.
     */
    @Test
    public void testAdd() {
        //Positive Test Case
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("hello");
        employee.setAddress("jaipur");
        EmployeeCollection collection = new EmployeeCollection();
        boolean expResult = true;
        boolean result = collection.add(employee);
        assertEquals(expResult, result);
        
        //Duplicate Test Case
        employee = new Employee();
        employee.setEmpId(1);
        expResult = false;
        result = collection.add(employee);
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class EmployeeCollection.
     */
    @Test
    public void testSize() {
        //Empty Test Case
        EmployeeCollection collection = new EmployeeCollection();
        int expResult = 0;
        int result = collection.size();
        assertEquals(expResult, result);
        
        //Positive Test Case
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("hello");
        employee.setAddress("jaipur");
        collection.add(employee);
        expResult = 1;
        result = collection.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class EmployeeCollection.
     */
    @Test
    public void testIsEmpty() {
        EmployeeCollection collection = new EmployeeCollection();
        boolean expResult = true;
        boolean result = collection.isEmpty();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of toList method, of class EmployeeCollection.
//     */
//    @Test
//    public void testToList() {
//        EmployeeCollection collection = new EmployeeCollection();
//        List<Employee> expResult = null;
//        List<Employee> result = collection.toList();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of contains method, of class EmployeeCollection.
//     */
//    @Test
//    public void testContains() {
//        Object o = null;
//        EmployeeCollection collection = new EmployeeCollection();
//        boolean expResult = false;
//        boolean result = collection.contains(o);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of iterator method, of class EmployeeCollection.
//     */
//    @Test
//    public void testIterator() {
//        EmployeeCollection collection = new EmployeeCollection();
//        Iterator expResult = null;
//        Iterator result = collection.iterator();
//        assertEquals(expResult, result);
//    }

    
    
}
