package com.metacube.ds.arrayList;

import com.metacube.ds.MyList;
import java.util.Arrays;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class MyArrayList<T> implements MyList<T> {
        
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     */
    private Object elements[];
        
    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;
    
    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @exception IllegalArgumentException if the specified initial capacity
     *            is negative
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elements = new Object[initialCapacity];
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        this(10);
    }
    
    /**
     * Increases the capacity of this ArrayList instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity){
                newCapacity = minCapacity;
            }
            // minCapacity is usually close to size, so this is a win:
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
    
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * @param object Object to be find
     * @return location of the object
     */
    @Override
    public int indexOf(Object object) {
        int position = -1;
        if (object == null) {
            
            for (int index = 0; index < size; index++){
                if (elements[index] == null){
                    position =  index;
                    break;
                }
            }
            
        } else {
            
            for (int index = 0; index < size; index++){
                if (object.equals(elements[index])){
                     position =  index;
                     break;
                }
            }
            
         }
         return position;
     }
    
    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T element) {
        ensureCapacity(size + 1);   // Increments modCount
        elements[size++] = element;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public void add(int index, T element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);  // Increments modCount
        System.arraycopy(elements, index, elements, index + 1,
                         size - index);
        elements[index] = element;
        size++;
    }
    
    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public T remove(int index) {
        rangeCheck(index);
        T oldValue = elements(index);

        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elements, index + 1, elements, index,
                             numMoved);
        }
        elements[--size] = null; // Let gc do its work

        return oldValue;
    }
    
    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.
     *
     * @param object element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object object) {
        boolean result = false;
        if (object == null) {
            for (int index = 0; index < size; index++){
                if (elements[index] == null) {
                    fastRemove(index);
                    result = true;
                }
            }
        } else {
            for (int index = 0; index < size; index++){
                if (object.equals(elements[index])) {
                    fastRemove(index);
                    result = true;
                }
            }
        }
        return result;
    }
    
    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        
        // Let gc do its work
        for (int index = 0; index < size; index++){
            elements[index] = null;
        }

        size = 0;
    }

    @Override
    public boolean addAll(int index, MyList<T> list) {
        rangeCheckForAdd(index);

        Object[] a = list.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);  // Increments modCount

        int numMoved = size - index;
        if (numMoved > 0){
            System.arraycopy(elements, index, elements, index + numNew,
                             numMoved);
        }

        System.arraycopy(a, 0, elements, index, numNew);
        size += numNew;
        return numNew != 0;
    }
    
    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the
     * specified collection's Iterator.
     *
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(MyList<T> list) {
        Object[] arr = list.toArray();
        int numNew = arr.length;
        ensureCapacity(size + numNew);  // Increments modCount
        System.arraycopy(arr, 0, elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }
    
    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public T set(int index, T element) {
        rangeCheck(index);

        T oldValue = elements(index);
        elements[index] = element;
        return oldValue;
    }
    
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
     }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size(){
        return size;
    }
    
    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        return (T) elements[index];
    }
    
    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
    */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    
    // Positional Access Operations

    @SuppressWarnings("unchecked")  
    private T elements(int index) {
        return (T) elements[index];
    }
    
    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void rangeCheck(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    /*
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elements, index+1, elements, index,
                             numMoved);
        }
        elements[--size] = null; // Let gc do its work
    }
    
    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in
     *         proper sequence
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }
    
}
