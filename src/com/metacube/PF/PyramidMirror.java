package com.metacube.PF;

/**
 * PFAssignment2 - Pyramid Mirror Using Modular Approach
 * @author User
 */
public class PyramidMirror {
    
    /**
     * Produce whole Pattern using spaces and numbers
     * @param n Integer
     * @return String Pattern
     */
    public String displayPyramid(int n){
        String numbers;
        String spaces;
        StringBuilder result = new StringBuilder();
        
        for (int loopCounter = 1; loopCounter <= n; loopCounter++)
        {
            spaces = spaces(loopCounter, n);
            result.append(spaces);
            numbers = numbers(loopCounter, n);
            result.append(numbers).append("\n");
        }
        for (int loopCounter = n - 1; loopCounter >= 1; loopCounter--)
        {
            spaces = spaces(loopCounter, n);
            result.append(spaces);
            numbers = numbers(loopCounter, n);
            result.append(numbers).append("\n");
        }
        result = result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    /**
     * Provide Spaces for the Pattern
     * @param row Integer
     * @param n Integer
     * @return String Spaces in Pattern
     */
    public String spaces(int row, int n)
    {
        StringBuilder space = new StringBuilder();
        
        for (int spaceCounter = 0; spaceCounter < (n - row); spaceCounter++)
        {
            space.append(' ');
        }
        return space.toString();
    }

    /**
     * Provide Numbers for the Pattern
     * @param row String
     * @param n String
     * @return String of Numbers in Pattern
     */
    public String numbers(int row, int n)
    {
        if(row<=n) 
        {
        StringBuilder numbers=new StringBuilder();

        for (int numberCounter = 1; numberCounter <= row; numberCounter++)
        {
            numbers.append(numberCounter);
        }
        for (int numberCounter = row - 1; numberCounter >= 1; numberCounter--)
        {
            numbers.append(numberCounter);
        }
        
        return numbers.toString();
        }
        else 
        {
            return "row must be less than pyramid size";
        }
    }
}
