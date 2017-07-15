package com.metacube.PF;

import java.util.Arrays;

/**
 * PFAssignment2 - Remove Duplicates Element From Input Array
 * @author Gaurav
 */
public class RemoveDuplicates {
    /**
     * 
     * @param input integer array
     * @return output integer array 
     */
    
    public int[] removeDuplicate(int input[]) {    
        int count = 0;                                 
        int[] output = new int[input.length];           
        for(int index = 0 ; index < input.length ; index++) {
            if (!elementExists(input[index] , output)) {
                output[count] = input[index];
                count++;
            }
        }
        output = Arrays.copyOfRange(output, 0, count); 
        return output;
    }

    /**
     * 
     * @param element integer to be found in input array
     * @param input integer array
     * @return 
     */
    public boolean elementExists(int element, int[] input) {
        boolean flag = false;                               
        for(int index = 0 ; index < input.length ; index++) {
            if(input[index] == element) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
