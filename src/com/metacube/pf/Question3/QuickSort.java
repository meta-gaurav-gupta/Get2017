package com.metacube.pf.Question3;

/**
 *
 * @author Gaurav
 */
public class QuickSort {
    /**
     * Partitioning an array into two parts using recursion
     * @param input Integer Array
     * @param indexOfLower Lower Index of Array
     * @param indexOfUpper Upper Index of Array
     * @return Integer
     */
    int partitioning(int[] input, int indexOfLower, int indexOfUpper) {
        int pivotElement = input[indexOfUpper];
        int leastIndex = indexOfLower - 1;
        try {
            if (input.length < 1) {
                throw new Exception("Length of input array must be greater than 0"); 
            }
            for(int loopCounter = indexOfLower ; loopCounter < indexOfUpper ; loopCounter++) {
                if (input[loopCounter] <= pivotElement) {
                    leastIndex++;
                    int tempElement = input[loopCounter];
                    input[loopCounter] = input[leastIndex];
                    input[leastIndex] = tempElement;
                }
            }
            int pivotChanging = input[leastIndex + 1];
            input[leastIndex + 1] = input[indexOfUpper]; 
            input[indexOfUpper] = pivotChanging;

        } catch(Exception lengthError) {
            System.out.println("Caught: " + lengthError.getMessage());
        } 

        return leastIndex + 1;
    }
	
    /**
     * Quick Sort to sort the array using Recursion
     * @param input Integer Array
     * @param indexOfLower Lower Index of Array
     * @param indexOfUpper Upper Index of Array
     * @return Integer Sorted Array
     */
    int [] quickSort(int[] input, int indexOfLower, int indexOfUpper) {

        try {
            if (input.length < 1) {
                throw new Exception("Length of input array must be greater than 0"); 
            }
            if(indexOfLower < indexOfUpper){
                int indexOfPartitioning = partitioning(input, indexOfLower, indexOfUpper);
                //Recursion 
                quickSort(input, indexOfLower, indexOfPartitioning - 1);
                quickSort(input, indexOfPartitioning  +1, indexOfUpper);
            }
        } catch(Exception lengthError) {
            System.out.println("Caught: " + lengthError.getMessage());
        }

        return input;
    }
}
