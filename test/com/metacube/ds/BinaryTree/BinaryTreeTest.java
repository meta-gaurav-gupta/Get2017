/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.BinaryTree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class BinaryTreeTest {

    /**
     * Test of mirror method, of class BinaryTree.
     */
    @Test
    public void testMirror() {
        //Positive Test Case
        BinaryTree firstTree = new BinaryTree();
        firstTree.insertNode(1);
        firstTree.insertNode(2);
        firstTree.insertNode(3);
        firstTree.insertNode(4);
        firstTree.insertNode(5);
        firstTree.insertNode(6);
        firstTree.insertNode(7);
        
        BinaryTree secondTree = new BinaryTree();
        secondTree.insertNode(1);
        secondTree.insertNode(3);
        secondTree.insertNode(2);
        secondTree.insertNode(7);
        secondTree.insertNode(6);
        secondTree.insertNode(5);
        secondTree.insertNode(4);
        
        boolean expResult = true;
        boolean result = firstTree.mirror(secondTree);
        assertEquals(expResult, result);
        
        //Negative Test Case
        BinaryTree thirdTree = new BinaryTree();
        thirdTree.insertNode(1);
        thirdTree.insertNode(2);
        thirdTree.insertNode(3);
        
        expResult = false;
        result = firstTree.mirror(thirdTree);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoot method, of class BinaryTree.
     */
    @Test
    public void testGetRoot() {
        BinaryTree tree = new BinaryTree();
        tree.insertNode(1);
        tree.insertNode(2);
        tree.insertNode(3);
        Node expResult = new Node(1);
        Node result = tree.getRoot();
        assertEquals(expResult.getData(), result.getData());
    }
    
}
