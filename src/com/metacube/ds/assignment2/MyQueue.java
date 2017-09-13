package com.metacube.ds.assignment2;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class MyQueue<T extends Object> {
    
    private Queue<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }
    
    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions
     *
     * @param data the element to add
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    public void enqueue(T data){
        try{
            queue.add(data);
        } catch(Exception ex) {
            Logger.getLogger(MyQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retrieves and removes the head of this queue. It throws an exception if this
     * queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue(){
        T data = null;
        try{
            data = queue.remove();
        } catch(NoSuchElementException ex){
            Logger.getLogger(MyQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    public T peek(){
        return queue.peek();
    }
    
    public void clear(){
        try {
            queue.clear();
        } catch(Exception ex) {
            Logger.getLogger(MyQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return the string
     */
    @Override
    public String toString() {
        String output;
        if(queue.isEmpty()){
            output = "Queue Is Empty!";
        } else {
            output = queue.toString();
        }
        
        return output;
    }
}
