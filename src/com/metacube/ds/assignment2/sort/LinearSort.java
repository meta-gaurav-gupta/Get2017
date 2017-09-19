package com.metacube.ds.assignment2.sort;

import com.metacube.ds.assignment2.enums.SortType;
import com.metacube.ds.assignment2.utils.Utils;



/**
 *
 * @author Gaurav
 */
public class LinearSort implements Sort {

    
    
    @Override
    public SortType sort(int[] numbers) {
        return sortUtils(numbers);
    }
    
    /**
     * Return type of sorting technique used to sort the array
     * @param numbers integer array
     * @return Sort Type Enumeration
     */
    private SortType typeOfSort(int[] numbers){
        int len = numbers.length;
        SortType result = SortType.COUNTING_SORT;
        for(int index = 0 ; index<len ; index++) {
            if(numbers[index]>99 || numbers[index]<(-99)) {
                result = SortType.RADIX_SORT;
            }
        }
        return result;
    }
    
    /**
     * Utility method for sort method
     * @param numbers integer array
     * @return type of sorting technique
     */
    private SortType sortUtils(int[] numbers){
        int length = numbers.length;
        int sizeOfNegativeArray = 0;
        int sizeOfPositiveArray = 0;
        int element;
        int positiveIndex = 0;
        int negativeIndex = 0;
        
        for(int index = 0; index < length; index++) {
            element = numbers[index];
            if(element < 0) {
                sizeOfNegativeArray++;
            } else if(element >= 0) {
                sizeOfPositiveArray++;
            }
        }
        
        int[] negtiveArray = new int[sizeOfNegativeArray];
        int[] positiveArray = new int[sizeOfPositiveArray];
        
        for(int index = 0; index < length; index++) {
            element = numbers[index];
            if(element < 0) {
                negtiveArray[negativeIndex++] = element * (-1); 
            } else if(element >= 0) {
                positiveArray[positiveIndex++] = element;
            }
        }
        SortType sortType = typeOfSort(numbers);
        switch(sortType) {
            case COUNTING_SORT:
                if(sizeOfNegativeArray > 0) {
                    countingSort(negtiveArray);
                }
                if(sizeOfPositiveArray > 0) {
                    countingSort(positiveArray);
                }
                break;
            case RADIX_SORT:
                if(sizeOfNegativeArray > 0) {
                    radixSort(negtiveArray);
                }
                if(sizeOfPositiveArray > 0) {
                    radixSort(positiveArray);
                }
                break;
        }
        
        for(int index = 0; index < negativeIndex; index++) {
            numbers[index] = negtiveArray[index] * (-1);
        }
        
        for(int index = negativeIndex; index < numbers.length; index++) {
            numbers[index] = positiveArray[index - negativeIndex];
        }
        
        return sortType;
    }
    
    /**
     * Counting sort
     * @param numbers integer array 
     */
    private void countingSort(int[] numbers){
        int minKey = findMinimum(numbers);
        int maxKey = findMaximum(numbers);
        /**
         * Index array to contain the count from min element of the input array to max element of the array
         * example in {2,5,3,0,2,3,0,3} min is 0 max is 5
         * array contains {0,1,2,3,4,5}
        */
        int indexArray[] = new int[maxKey - minKey + 1];
        
        for(int index = 0; minKey <= maxKey; index++, minKey++){
            indexArray[index] = minKey;
        }            
        
        /**
         * Counter array to contain the occurrence of the element exists in the input array
         * first fill the counter array with O's
         * example in {2,5,3,0,2,3,0,3}
         * array contains {0,1,2,3,4,5} -> {2,0,2,3,0,1}
         * 0 occur 2 times 1 didn't occur and so on
         */
        int counter[] = new int[indexArray.length + 1];
        Utils.fill(counter, 0);
        for(int index = 0; index < numbers.length; index++) {
            counter[numbers[index]]++;
        }
        
        /**
         * sum count array will contain the cumulative sum of the counter array
         * example in {2,5,3,0,2,3,0,3}
         * counter array is {2,0,2,3,0,1}
         * index array contains {0,1,2,3,4,5}
         * cumulative sum array will contain {2, 2, 4, 7, 7, 8, 8}
         * counter[i] = counter[i-1] + counter[i] <- cumulative sum
         */
        int sumCount[] = new int[counter.length];
        int prevCount = 0;
        
        for(int index = 0; index < sumCount.length; index++) {
            sumCount[index] = counter[index] + prevCount;
            prevCount = sumCount[index];
        }
        
        /**
         * output array contains the sorted elements
         */
        int[] output = numbers.clone();
        int element;
        
        for(int index = 0; index < numbers.length; index++) {
            element = numbers[index];
            output[sumCount[element] - 1] = element;
            sumCount[element]--;
        }
        
        /**
         * copy output array to the origin array
         */
        Utils.arrayCopy(numbers, output);
    }
    
    /**
     * Find smallest element in array
     * @param numbers integer array
     * @return smallest integer
     */
    private int findMinimum(int numbers[]){
        int min = numbers[0];
        for(int element : numbers){
            if(element < min){
                min = element;
            }
        }
        return min;
    }
    
    /**
     * Find largest element in array
     * @param numbers integer array
     * @return smallest integer
     */
    private int findMaximum(int numbers[]){
        int max = numbers[0];
        for(int element : numbers){
            if(element > max){
                max = element;
            }
        }
        return max;
    }
    

    /**
     * Radix sort.
     *
     * This method sorts the array using radix sort
     * @param numbers integer array
     */
    private void radixSort(int[] numbers) {
        int max = findMaximum(numbers);
        int length = numbers.length;

        int position;
        int[] bucket;
        int[] output = new int[length];
        
        for(int exp = 1; max / exp > 0; exp *=10) {

            bucket = new int[10];

            /**
             * Taking least significant digit in bucket
             */
            for (int index = 0; index < length; index++) {
                bucket[(numbers[index] / exp) % 10]++;
            }
            /**
             * Summing up the bucket values
             */
            for (int index = 1; index < bucket.length; index++) {
                bucket[index] += bucket[index - 1];
            }
            /**
             * this loop will take the radix value count store in bucket and store them in array output
             */
            for (int index = length - 1; index>= 0; index--) {
                position = (--bucket[(numbers[index] / exp) % 10]); 
                output[position] = numbers[index];
            }
            /**
             * copying the array into original array
             */
            Utils.arrayCopy(numbers, output);
        }
    }
}
