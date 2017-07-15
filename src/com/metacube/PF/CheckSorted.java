package com.metacube.PF;


/**
 * PFAssignment5 - Find Out If The Array Is Sorted Or Not, If Sorted Determine The Order 
 * @author User
 */
public class CheckSorted {
    /**
     * @param input integer array
     * @return integer ( 0 -> not sorted 1 -> ascending sort 2 -> descending sort
     */
    public int checkSort(int[] input){
        int flagAsc = 0;
        int flagDesc = 0;
        int result;
        for (int i = 1 ; i < input.length ; i++){
            if (input[i] > input[i - 1]){
                flagAsc++;
            }else if (input[i] < input[i - 1]){
                flagDesc++;
            }
        }
        if (flagAsc == input.length - 1) {
            result =  1;
        }else if (flagDesc == input.length - 1) {
            result =  2;
        }else {
            result =  0;
        }
        
        return result;
    }
}
