package com.metacube.pf.Question2;

/**
 *
 * @author Gaurav
 */
public class BinarySearch {
    /**
     * Search For An Element in the array by using Divide and Conquer Principle
     * @param input Integer Array
     * @param search Integer Element to be searched
     * @param indexOfLower Integer Lower Index Of Array
     * @param indexOfUpper Integer Upper Index Of Array
     * @return Integer if -1 then Element Not Found
     */
    public int binarySearch(int[] input, int search,int indexOfLower,int indexOfUpper) {
        int mid = indexOfLower + (indexOfUpper - indexOfLower) / 2;
        try{
            if(indexOfUpper >= indexOfLower) {
                if(input[mid] == search) {
                    return mid;
                }
                if(input[mid] > search) {
                    return binarySearch(input, search, indexOfLower, mid - 1);  // if input[mid] is less than searching element
                }
                if(input[mid] < search) {
                    return binarySearch(input, search, mid + 1, indexOfUpper);  // if input[mid] is greater than searching element
                }
            }
        } catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        return -1;
    }
}
