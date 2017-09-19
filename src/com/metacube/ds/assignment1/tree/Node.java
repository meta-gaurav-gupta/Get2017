package com.metacube.ds.assignment1.tree;

/**
 *
 * @author Gaurav
 * @param <T>
 */
public class Node<T extends Comparable<T>> {
    
    /**
     * Node Data
     */
    private T data;
    
    /**
     * Left Node
     */
    private Node<T> left;
    
    /**
     * Right Node
     */
    private Node<T> right;

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
}
