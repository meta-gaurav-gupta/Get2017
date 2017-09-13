package com.metacube.ds.assignment1.entity;

import java.util.Arrays;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class PriorityQueue<T extends Object> {
    
    private T[] heap; 
    
    /**
     * The number of elements in the priority queue.
     */
    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    
    /**
     * Creates a PriorityQueue with the default initial
     * capacity (11) that orders its elements according to their
     * natural ordering
     */
    public PriorityQueue(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    /**
     * Creates a PriorityQueue with the specified initial capacity
     * that orders its elements according to the specified comparator.
     *
     * @param  initialCapacity the initial capacity for this priority queue
     * @throws IllegalArgumentException if {@code initialCapacity} is
     *         less than 1
     */
    public PriorityQueue(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.heap = (T[])new Object[initialCapacity];
    }

    /**
     * Removes all of the elements from this priority queue.
     * The queue will be empty after this call returns.
     */
    public void clear(){
        for (int i = 0; i < size; i++) {
            heap[i] = null;
        }
        size = 0;
    }

    /**
     * Check if the queue is empty
     * @return true if the queue is empty otherwise false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Check if the queue if full
     * @return true if the queue if full otherwise false
     */
    public boolean isFull(){
        return size == DEFAULT_INITIAL_CAPACITY - 1;
    }

    /**
     * Return the size of the queue
     * @return Integer size of the queue
     */
    public int size(){
        return size;
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param data to be inserted into this priority queue
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public void insert(T data){   
        if (data == null)
            throw new NullPointerException();
        int i = size;
        if (i >= heap.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            heap[0] = data;
        else
            siftUp(i, data);
    }
    
    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
    /**
     * Increases the capacity of the array.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = heap.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        heap = Arrays.copyOf(heap, newCapacity);
    }

    /**
     * Increase the size to the maximum of the queue
     * @param minCapacity integer
     * @return the huge size
     * @throws OutOfMemoryError in case of Requested array size exceeds VM limit
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
    
    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftUp(int k, T x) {
        Comparable<? super T> key = (Comparable<? super T>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            T e = heap[parent];
            if (key.compareTo((T) e) >= 0)
                break;
            heap[k] = e;
            k = parent;
        }
        heap[k] = (T) key;
    }

    /**
     * Inserts item x at position k, maintaining heap invariant by
     * demoting x down the tree repeatedly until it is less than or
     * equal to its children or is a leaf.
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftDown(int k, T x) {
        Comparable<? super T> key = (Comparable<? super T>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = heap[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super T>) c).compareTo((T) heap[right]) > 0)
                c = heap[child = right];
            if (key.compareTo((T) c) <= 0)
                break;
            heap[k] = (T) c;
            k = child;
        }
        heap[k] = (T) key;
    }
    
    /**
     * Removes a single instance of the specified element from this queue,
     * if it is present.
     *
     * @return the removed data
     */
    public T remove() {
        if (size == 0)
            return null;
        int s = --size;
        T result = (T) heap[0];
        T x = (T) heap[s];
        heap[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;

    }
}
