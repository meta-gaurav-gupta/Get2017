package com.metacube.pf.Question2;

/**
 *
 * @author Gaurav
 */
public class LinearSearch {
    
    /**
     * Search Element in array linearly - One by One
     * @param input Integer Array
     * @param search Element to be searched
     * @param indexOfLower Lower Index
     * @param indexOfUpper Upper Index
     * @return Integer if -1 then Element Not Found
     */
    int linearSearch(int input[], int search, int indexOfLower, int indexOfUpper) {
        try{
            if(indexOfLower > indexOfUpper) {
                return -1;
            }

            if(input[indexOfLower] == search) {
                return indexOfLower;
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        return linearSearch(input, search, indexOfLower + 1, indexOfUpper);
    }
}
