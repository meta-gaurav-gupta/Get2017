package com.metacube.ds.stack;


/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class Node<T extends Object> {

    /** Node data. */
    T data;

    /** Next node */
    Node<T> next;
    
    /**
     * Constructs a node with data.
     * @param data to be inserted in node
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }	
}
