package com.metacube.ds.assignment1.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaurav
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
    
    private Node<T> root;
	
    /**
     * Instantiates a new tree.
     *
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert.
     *
     * @param root the root
     * @param data the data
     * @return the node
     */
    private Node<T> insert(Node<T> root,T data) {
        if(root == null) {
            root = new Node<>(data);
        } else {
            if(data.compareTo(root.getData()) < 0 ) {
                root.setLeft(insert(root.getLeft(),data));
            } else {
                root.setRight(insert(root.getRight(),data));
            }
        }
        return root;
    }

    /**
     * Insert data.
     *
     * @param data the data
     * @return boolean true if successfully inserted, false if any error occurred
     */
    public boolean insertData(T data) {
        boolean result;
        try {
            this.root = insert(this.root,data); 
            result = true;
        }catch(Exception e) {
            result = false;
            System.out.println("Error Caught " + e.getMessage() + " while inserting the data");
        }
        return result;
    }

    /**
     * In order.
     *
     * @param root the root
     */
    private void inorder(Node<T> root, List<T> list)
    {
        if(root == null){
            return;
        }
            inorder(root.getLeft(),list);    
            list.add(root.getData()); 
            inorder(root.getRight(),list);
    }
    /*
     * String representation of tree
     */
    @Override
    public String toString() {
        List<T> list = new ArrayList<>();
        inorder(root,list);
        return list.toString();
    }
    
}
