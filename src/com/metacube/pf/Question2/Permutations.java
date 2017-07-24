package com.metacube.pf.Question2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class Permutations {
    private List<String> possiblePermutations = new ArrayList<String>();

    /**
     * Method take a input String , starting index of input array and second index and swap the values
     * @param inputString String
     * @param firstIndex Integer
     * @param secondIndex Integer
     * @return String after swapping
     */
    private String swap(String inputString, int firstIndex, int secondIndex) {
        char[] characterArray = inputString.toCharArray();
        char temp = characterArray[firstIndex];
        characterArray[firstIndex] = characterArray[secondIndex];
        characterArray[secondIndex] = temp;

        return String.valueOf(characterArray);
    }


        /**
         * Utility method for generatePermutations
         */

    private List<String> generatePermutationsUtils(String inputString, int lowIndex, int highIndex) {

        if (lowIndex == highIndex) {
            if (!possiblePermutations.contains(inputString)) {
                possiblePermutations.add(inputString);
            }
        } else {
            for (int iterateIndex = lowIndex; iterateIndex <= highIndex; iterateIndex++) {
                inputString = swap(inputString, iterateIndex, lowIndex);
                generatePermutationsUtils(inputString, lowIndex + 1, highIndex);
                inputString = swap(inputString, iterateIndex, lowIndex);
            }
        }

        return possiblePermutations;
    }
    
    /**        
     * Method Generates all possible permutation of input String
     * @param inputString String
     * @return List of String mentioning the list of permutations 
     */
    public List<String> generatePermutations(String inputString) {
        List<String> resultList = new ArrayList<>();
        try {
            if(inputString.length() == 0){
                throw new Exception("Input String Is Empty");
            }
            int lowIndex = 0;
            int highIndex = inputString.length() - 1;
            resultList = generatePermutationsUtils(inputString, lowIndex, highIndex);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            resultList = null;
        }
        return resultList;
    }
}
