package com.metacube.PF;

/**
 * PFAssignment3 - Find Longest Continuous Sequence In Input Array
 * @author User
 */
public class LongestIncreasingSequence {
    /**
     * @param input integer array
     * @return integer array which contains longest sequence in the input array
     */
    public int[] longestSequence(int[] input) {
        int startPoint = 0;
        int endPoint = 0;
        int helperStaringMarker = 0;
        int helperEndingMarker = 0;
        for(int i = 1 ; i < input.length ; i++) {
            if(input[i] > input[i - 1]) {
                endPoint++;
            }else if((input[i] < input[i - 1])) {
                if((helperEndingMarker - helperStaringMarker) <= (endPoint - startPoint)) {
                    helperStaringMarker = startPoint;
                    startPoint = i - 1;
                    helperEndingMarker = endPoint;
                    endPoint = i;
                }else {
                    startPoint = i - 1;
                    endPoint = i;
                }
            }else if(input[i] == input[i - 1]) {
                startPoint = i - 1;
                endPoint = i;
            }

            if(i == (input.length-1)) {
                if((helperEndingMarker - helperStaringMarker) <= (endPoint - startPoint)) {
                    helperStaringMarker = startPoint;
                    startPoint = i;
                    helperEndingMarker = endPoint;
                    endPoint = i;
                }
            }
        }
        int[] resultArray = new int[ helperEndingMarker - helperStaringMarker ];
        for(int index = 0 ; index < resultArray.length ; index++) {
            if(helperStaringMarker != helperEndingMarker) {
                resultArray[index] = input[ ++helperStaringMarker ];
            }else {
                break;
            }
        }
        
        return resultArray;
    }
}
