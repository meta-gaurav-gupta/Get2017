/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.DoublyLinkedList;

import com.metacube.ds.MyList;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class DoublyLinkedList<T extends Object> implements MyList<T>{
    /**
     * Pointer to head(start) node.
     */
    private Node<T> head;
    
    /**
     * Constructs an empty list.
     */
    public DoublyLinkedList(){
        
    }
    
    /**
     * Appends the specified element to the end of this list.
     *
     * @param data element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T data) {
        Node<T> current = head;
        Node<T> newNode = new Node<>(data); 
        if(head == null){
            head = newNode;
        }
        else{
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param data element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(int index, T data) {
        checkPositionIndex(index);
        Node<T> newNode = new Node<>(data); 
        Node<T> current = head;
        if(head == null){
            head = newNode;
        }
        else{
            for(int position = 0; position < index; position++){
                current = current.next;
            }
            current.previous.next = newNode;
            newNode.next = current;
            current.previous = newNode;
        }
    }
    
    /**
     * Removes the first occurrence of the specified element from this list
     *
     * @param obj element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(Object obj) {
        boolean result = false;
        if (obj == null) {
            for (Node<T> current = head; current != null; current = current.next) {
                if (current.data == null) {
                    unlink(current);
                    result = true;
                }
            }
        } else {
            for (Node<T> current = head; current != null; current = current.next ) {
                if (obj.equals(current.data)) {
                    unlink(current);
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Removes the element at the specified position in this list. 
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public T remove(int index) {
        checkElementIndex(index);
        Node<T> current = head;
        for(int position = 0; position < index; position++){
            current = current.next;
        }
        return unlink(current);
    }
    
    /**
     * Unlinks non-null node current.
     */
    private T unlink(Node<T> current) {
        // assert x != null;
        final T element = current.data;
        if(current.previous == null){
            head = null;
        }
        else{
            current.previous.next = current.next;
            current.previous = current.next.previous;
        }
        return element;
    }
    
    /**
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        Node<T> currentNode = head;
        int size = 0;
        
        if(currentNode != null){
        
            while(currentNode != null){
                currentNode = currentNode.next;
                size++;
            
            }
        }
        
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list
     *         in proper sequence
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        int index = 0;
        for (Node<T> current = head; current != null; current = current.next)
            result[index++] = current.data;
        return result;
    }
    
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }
    
    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T set(int index, T element) {
        checkElementIndex(index);
        Node<T> node = node(index);
        T oldVal = node.data;
        node.data = element;
        return oldVal;
    }
    
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param obj element to search for
     * @return the index
     */
    @Override
    public int indexOf(Object obj) {
        int position = 0;
        int index = -1;
        if (obj == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.data == null)
                    index = position;
                position++;
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (obj.equals(x.data))
                    index = position;
                position++;
            }
        }
        return index;
    }
    
    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.next;
            x.data = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        
        head = null;
    }
    
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    
    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }
    
    /**
     * Tells if the argument is the index of a valid position for an
     * add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size();
    }
    
    /**
     * Constructs an IndexOutOfBoundsException detail message.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size();
    }
    
    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private Node<T> node(int index) {
        // assert isElementIndex(index);

        Node<T> x = head;
        for (int i = 0; i < index; i++){
            x = x.next;
        }
        return x;
    }
    
    /**
     * Appends all of the elements in the specified collection to the end of
     * this list
     *
     * @param list collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(MyList<T> list) {
        //TODO append list to the current instance of list
        return false;
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list, starting at the specified position.
     *
     * @param index index at which to insert the first element
     *              from the specified collection
     * @param list collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws IndexOutOfBoundsException
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(int index, MyList<T> list) {
        //TODO append list to the current instance of list starting from index
        return false;
    }

}
