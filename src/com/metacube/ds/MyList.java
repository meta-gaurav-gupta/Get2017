package com.metacube.ds;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public interface MyList<T extends Object>{
    
    /**
     * @return the number of elements in this list
     */
    int size();
    
    /**
     * @return true if this list contains no elements
     */
    boolean isEmpty();
    
    /**
     * 
     * @return an array containing all of the elements in this list in proper sequence
     */
    Object[] toArray(); 
    
    /**
     * 
     * @param t element to be appended to this list
     * @return true if this collection changed as a result of the call
     */
    boolean add(T t);
    
    /**
     * 
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    boolean remove(Object o);
    
    /**
     * 
     * @param list
     * @return true if this list changed as a result of the call
     */
    boolean addAll(MyList<T> list);
    
    /**
     * 
     * @param index index at which to insert the first element from the specified collection
     * @param list
     * @return true if this list changed as a result of the call
     */
    boolean addAll(int index, MyList<T> list);
    
    /**
     * Removes all of the elements from this list (optional operation). 
     * The list will be empty after this call returns. 
     */
    void clear();
    
    /**
     * 
     * @param o the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    @Override
    boolean equals(Object o);
    
    /**
     * 
     * @return the hash code value for this list
     */
    @Override
    int hashCode();
    
    /**
     * 
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    T get(int index);
    
    /**
     * 
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    T set(int index, T element);
    
    /**
     * 
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void add(int index, T element);
    
    /**
     * 
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    T remove(int index);
    
    /**
     * 
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int indexOf(Object o);
    
}
