package com.metacube.ds;

/**
 *
 * @author Gaurav
 */
public class Utility {
        
    /**
     * Sorts the specified list according to the order induced by the
     * specified comparator.
     *
     * @param  list the list to be sorted. 
     * @throws ClassCastException if the list contains elements that are not
     *         mutually comparable using the specified comparator.
     * @throws UnsupportedOperationException if the specified
     *         list-iterator of list does not support the set operation.
     */
    @SuppressWarnings("unchecked")
    public static <T> void sort(MyList<T> list){
        Object[] a = list.toArray();
        mergeSort(a, 0, a.length - 1);
        list.clear();
        for(Object obj : a){
            list.add((T)obj);
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
        for (int k = 0; k < numbersToSort; k++) {
            arValues[low + k] = arTemp[k];
        }
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
    
    /**
     * Reverses the order of the elements in the specified list.
     *
     * @param  list the list whose elements are to be reversed.
     * @throws UnsupportedOperationException if the specified list or
     *         its list-iterator does not support the set operation.
     */
    public static void reverse(MyList list) {
        int size = list.size();
        for (int indexOfFirst = 0, mid = size>>1, indexOfSecond = size - 1; indexOfFirst < mid; indexOfFirst++, indexOfSecond--){
            swap(list, indexOfFirst, indexOfSecond);
        }
    }
    
    /**
     * Swaps the elements at the specified positions in the specified list.
     *
     * @param list The list in which to swap elements.
     * @param indexOfFirst the index of one element to be swapped.
     * @param indexOfSecond the index of the other element to be swapped.
     * @throws IndexOutOfBoundsException if either indexOfFirst or indexOfSecond
     *         is out of range
     */
    public static void swap(MyList list, int indexOfFirst, int indexOfSecond) {
        final MyList myList = list;
        myList.set(indexOfFirst, myList.set(indexOfSecond, myList.get(indexOfFirst)));
    }
}
