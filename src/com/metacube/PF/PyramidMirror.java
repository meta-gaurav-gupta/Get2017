package com.metacube.PF;

/**
 * PFAssignment2 - Pyramid Mirror Using Modular Approach
 * @author Gaurav
 */
public class PyramidMirror {
    
    /**
     * Produce whole Pattern using spaces and numbers
     * @param n Integer
     * @return String Pattern
     */
    public String[] displayPyramid(int n){
        StringBuilder mStringBuilder = new StringBuilder();
        try{
            n = Integer.parseInt(n + "");
            if(n < 1){
                throw new Exception("Input Must Be Greater Than Zero");
            }
            for (int loopCounter = 1; loopCounter <= n; loopCounter++){
                String upperBody = patternBuilder(loopCounter, n);
                mStringBuilder.append(upperBody);
            }
            for (int loopCounter = n - 1; loopCounter >= 1; loopCounter--){
                String lowerBody = patternBuilder(loopCounter, n);
                mStringBuilder.append(lowerBody);
            }
            mStringBuilder = mStringBuilder.deleteCharAt(mStringBuilder.length()-1);
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String[] result = mStringBuilder.toString().split("\n");
        return result;
    }
    
    /**
     * Build pattern by using spaces and numbers
     * @param loopCounter Integer
     * @param n Integer
     * @return String pattern with spaces and numbers
     */
    public String patternBuilder(int loopCounter, int n){
        StringBuilder result = new StringBuilder();
        try {
            n = Integer.parseInt(n + "");
            loopCounter = Integer.parseInt(loopCounter + "");
            if(n < 1) {
                throw new Exception("Input Must Be Greater Than Zero");
            }
            if(loopCounter > n) {
                throw new Exception("Loop Counter must be smaller than input");
            }
            String spaces = spaces(loopCounter, n);
            result.append(spaces);
            String numbers = numbers(loopCounter, n);
            result.append(numbers).append("\n");
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
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
        try{
            n = Integer.parseInt(n + "");
            row = Integer.parseInt(row + "");
            if(n < 1) {
                throw new Exception("Input Must Be Greater Than Zero");
            }
            if(row > n) {
                throw new Exception("Row must be smaller than input");
            }
            
            for (int spaceCounter = 0; spaceCounter < (n - row); spaceCounter++)
            {
                space.append(' ');
            }
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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
        StringBuilder numbers=new StringBuilder();
        try{
            n = Integer.parseInt(n + "");
            row = Integer.parseInt(row + "");
            if(n < 1) {
                throw new Exception("Input Must Be Greater Than Zero");
            }
            if(row > n) {
                throw new Exception("Row must be smaller than input");
            }
            for (int numberCounter = 1; numberCounter <= row; numberCounter++)
            {
                numbers.append(numberCounter);
            }
            for (int numberCounter = row - 1; numberCounter >= 1; numberCounter--)
            {
                numbers.append(numberCounter);
            }
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return numbers.toString();
    }
}
