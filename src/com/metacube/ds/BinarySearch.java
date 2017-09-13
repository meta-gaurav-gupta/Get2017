package com.metacube.ds;

/**
 *
 * @author Gaurav
 */
public class BinarySearch {
    
    /**
     * binary search function to find the leftmost occurrence of x in the array 
     * in case the occurrences are not unique 
     * (if it is actually in the array, −1 as before if it is not).
     *
     * @param input Integer Array
     * @param searchItem Integer data to be search in array
     * @return Integer position of the search item, -1 in case of not found
     */
    public int binarySearch(int[] input ,int searchItem) {
        int min = 0;
        int max = input.length - 1;
        int mid = (min + max ) / 2;
        int position = -1;

        while (min < max) {
            if (input[mid] == searchItem) {
                position = mid;
                max = mid;
            } else if (input[mid] > searchItem) {
                max = mid - 1;
            } else if (input[mid] < searchItem) {
                min = mid + 1;
            }

            mid = (max + min ) / 2;
        }

        return position;
    }
    
}
