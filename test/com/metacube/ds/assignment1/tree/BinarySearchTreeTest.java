package com.metacube.ds.assignment1.tree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class BinarySearchTreeTest {

    /**
     * Test of insertData method, of class BinarySearchTree.
     */
    @Test
    public void testInsertData() {
        int data = 1;
        BinarySearchTree tree = new BinarySearchTree();
        boolean expResult = true;
        boolean result = tree.insertData(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class BinarySearchTree.
     */
    @Test
    public void testToString() {
        BinarySearchTree tree = new BinarySearchTree();
        String expResult = "[1, 2, 3]";
        tree.insertData(3);
        tree.insertData(1);
        tree.insertData(2);
        String result = tree.toString();
        assertEquals(expResult, result);
    }
    
}
