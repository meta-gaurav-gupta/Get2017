package com.metacube.ds.assignment1;

import com.metacube.ds.assignment1.utils.Utils;
import com.metacube.ds.assignment1.tree.BinarySearchTree;

/**
 *
 * @author Gaurav
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Enter Number Of Students");
        BinarySearchTree tree = new BinarySearchTree();
        int numberOfStudents = Utils.takePositiveIntegerAsInput();
        
        for(int index = 0; index < numberOfStudents; index++){
            System.out.println("Enter Roll Number Of Student");
            tree.insertData(Utils.takePositiveIntegerAsInput());
        }
        
        System.out.println("\nUsint Tree Sort\n" + tree);
    }
    
}
