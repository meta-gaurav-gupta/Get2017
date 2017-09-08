/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.stack;

/**
 *
 * @author Gaurav
 * @param <T>
 */
public class AbstractStack<T> {
    
    /**
    * Push.
    * This method push element at the top of stack
    * @param element the element
    */
    protected void push(T element){};

    /**
     * Pop.
     * This method removes the element from top of stack
     * @return the element of type T
     */
    protected T pop(){ return null; };

    /**
     * Peek.
     * This method returns the head element It does not remove the element from stack
     * @return the element of type T
     */
    protected T peek(){ return null; };
    
}
