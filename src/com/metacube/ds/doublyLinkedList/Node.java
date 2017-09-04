package com.metacube.ds.doublyLinkedList;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class Node<T extends Object> {

    /** Node data */
    T data;

    /** Next node */
    Node<T> next;
    
    /** Previous node */
    Node<T> previous;
    
    /**
     * Constructs a node with data.
     * @param data to be inserted in node
     */
    public Node(T data) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }	
}
