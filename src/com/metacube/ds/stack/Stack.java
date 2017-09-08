
package com.metacube.ds.stack;

import com.metacube.ds.SinglyLinkedList.SinglyLinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 * @param <T>
 */
public class Stack<T extends Object> extends AbstractStack<T>{

    private SinglyLinkedList<T> list;
    
    private int top;
    
    public Stack(){
        list = new SinglyLinkedList<>();
        this.top = -1;
    }
    
    /**
    * Push.
    * This method push element at the top of stack
    * @param element the element
    */
    @Override
    public void push(T element) {
        try {
        list.add(top + 1,element);
        } catch(OutOfMemoryError error) {
            Logger.getLogger(Stack.class.getName()).log(Level.SEVERE, error.getMessage());
        }
        top++;
    }


    /**
     * Pop.
     * This method removes the element from top of stack
     * @return the element of type T
     */
    @Override
    public T pop() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Underflow occured! Stack is empty.");
        }
        T element = list.get(top);
        list.remove(top);
        top--;
        return element;
    }


    /**
     * Peek.
     * This method returns the head element It does not remove the element from stack
     * @return the element of type T
     */
    @Override
    public T peek() {
        return list.get(top);
    }
    
    private boolean isEmpty(){
        return top == -1;
    }
}
