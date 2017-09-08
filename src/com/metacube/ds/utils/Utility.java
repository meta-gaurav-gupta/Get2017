package com.metacube.ds.utils;

import com.metacube.ds.queue.Queue;

/**
 *
 * @author Gaurav
 */
public class Utility {
        
    /**
     * Sorts the specified queue according to the order induced by the
     * specified comparator.
     *
     * @param <T>
     * @param  queue the queue to be sorted. 
     * @throws ClassCastException if the queue contains elements that are not
     *         mutually comparable using the specified comparator.
     * @throws UnsupportedOperationException if the specified
     *         queue-iterator of queue does not support the set operation.
     */
    @SuppressWarnings("unchecked")
    public static <T> void sort(Queue<T> queue){
        Object[] a = queue.toArray();
        mergeSort(a, 0, a.length - 1);
        queue.makeEmpty();
        for(Object obj : a){
            queue.enqueue((T)obj);
        }
    }
    
    private static void mergeSort(Object[] arValues, int low, int high) {
        if (low < high) {
            int middle = low + ((high - low) / 2);
            mergeSort(arValues, low, middle);
            mergeSort(arValues, middle + 1, high);
            merge(arValues, low, middle, high);
        }
    }

    private static  void merge(Object[] arValues, int low, int middle, int high) {
        int numbersToSort = (high - low) + 1;
        Object arTemp[] = new Object[numbersToSort];
        int lowIndex = low;
        int highIndex = middle + 1;
        Object lowValue = null;
        Object highValue = null;
        for (int index = 0; index < numbersToSort; index++) {
            lowValue = (lowIndex <= middle) ? arValues[lowIndex] : null;
            highValue = (highIndex <= high) ? arValues[highIndex] : null;
            if (checkBiggerSmaller(lowValue, highValue)) {
                arTemp[index] = arValues[lowIndex++];
            } else {
                arTemp[index] = arValues[highIndex++];
            }
        }
        // Transfer the sorted elements to the original array.
        System.arraycopy(arTemp, 0, arValues, low, numbersToSort);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean checkBiggerSmaller(Object lowValue, Object highValue) {
        boolean isGreater = false;
        boolean flag = true;
        if ((lowValue != null) && (highValue == null)) {
            isGreater = true;
            flag = false;
        } else if ((lowValue == null) && (highValue != null)) {
            isGreater = false;
            flag = false;
        }
        if (flag) {
            isGreater = ((Comparable)lowValue).compareTo(highValue) <= 0;
        }
        return isGreater;
    }
    
}
