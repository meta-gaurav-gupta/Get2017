package com.metacube.ds.BinaryTree;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class Node<T> {
    /** 
     * The data. 
     */
    private T data;

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /** 
     * The left node
     */
    private Node<T> left;

    /** 
     * The right node 
     */
    private Node<T> right;

    /**
     * Instantiates a new Node node.
     *
     * @param data
     */
    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Returns the left node.
     *
     * @return the Node node
     */
    public Node<T> getLeft(){
        return this.left;
    }

    /**
     * Return the right node
     *
     * @return the Node node
     */
    public Node<T> getRight(){
        return this.right;
    }

    /**
     * Set the left node.
     *
     * @param left node
     */
    public void setLeft(Node<T> left){
        this.left = left;
    }

    /**
     * Set the right node
     *
     * @param right node
     */
    public void setRight(Node<T> right){
        this.right = right;
    }
}
