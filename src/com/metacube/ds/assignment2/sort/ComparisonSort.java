package com.metacube.ds.assignment2.sort;

import com.metacube.ds.assignment2.enums.SortType;


/**
 *
 * @author Gaurav
 */
public class ComparisonSort implements Sort {

    @Override
    public SortType sort(int[] numbers) {
        SortType result = typeOfSort(numbers);
        switch(result){
            case BUBBLE_SORT:
                bubbleSort(numbers);
                break;
            case QUICK_SORT:
                quickSort(numbers, 0, numbers.length - 1);
        }
        return result;
    }
    
    /**
     * Return type of sorting technique used to sort the array
     * @param numbers integer array
     * @return Sort Type Enumeration
     */
    private SortType typeOfSort(int[] numbers) {
        SortType result = SortType.BUBBLE_SORT;
        if(numbers.length > 10) {
            result = SortType.QUICK_SORT;
        }
        return result;
    }
    
    /**
     * Bubble sort 
     * @param numbers integer array 
     */
    private void bubbleSort(int numbers[]){
        boolean swapped;    //will used to check if any element is swapped in previous step
        int leftElement;
        int rightElement;
        int indexOfLastUnsortedElement = numbers.length;
        do{
            swapped = false;
            for(int index = 1; index < indexOfLastUnsortedElement; index++){
                leftElement = numbers[index - 1];
                rightElement = numbers[index];
                if(leftElement > rightElement){
                    swap(numbers, index);
                    swapped = true;
                }
            }
        }while(swapped);
    }

    /**
     * Swap the two adjacent elements of the array
     * @param numbers
     * @param index 
     */
    private void swap(int[] numbers, int index) {
        int temp = numbers[index - 1];
        numbers[index - 1] = numbers[index];
        numbers[index] = temp;
    }
    
    /**
     * Swap two numbers in array
     * @param numbers integer array
     * @param indexFirst index of first element
     * @param indexSecond index of second element
     */
    private void swap(int[] numbers, int indexFirst, int indexSecond) {
        int temp = numbers[indexFirst];
        numbers[indexFirst] = numbers[indexSecond];
        numbers[indexSecond] = temp;
    }
    
    /**
     * Quick Sort
     * @param numbers integer array
     * @param lowerIndex index of the first element
     * @param higherIndex index of the last element
     */
    private void quickSort(int numbers[], int lowerIndex, int higherIndex) {
        int low = lowerIndex;
        int high = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = numbers[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (low <= high) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (numbers[low] < pivot) {
                low++;
            }
            while (numbers[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(numbers, low, high);
                //move index to next position on both sides
                low++;
                high--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < high)
            quickSort(numbers, lowerIndex, high);
        if (low < higherIndex)
            quickSort(numbers, low, higherIndex);
    }
    
}
