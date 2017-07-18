package com.metacube.PF;

/**
 * PFAssignment2 - Pattern Using Modular Approach
 * @author User
 */
public class Pyramid2 {
    
    /**
     * Produce whole Pattern using spaces and numbers
     * @param n Integer
     * @return String Pattern
     */
    public String pyramid(int n) {
        String numbers;
        String spaces;
        StringBuilder result = new StringBuilder();
        try{
            n = Integer.parseInt(n + "");
            if(n < 1){
                throw new Exception("Input Must Be Greater Than Zero");
            }
            for(int loopCounter = n;loopCounter >= 1; loopCounter--) {
                spaces = spaces(loopCounter, n);
                result.append(spaces);
                numbers = numbers(loopCounter, n);
                result.append(numbers).append("\n");
            }
            result = result.deleteCharAt(result.length()-1);
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
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
    public String spaces(int row, int n) {
        StringBuilder spaces = new StringBuilder();
        try{
            n = Integer.parseInt(n + "");
            row = Integer.parseInt(row + "");
            if(n < 1) {
                throw new Exception("Input Must Be Greater Than Zero");
            }
            if(row > n) {
                throw new Exception("Row must be smaller than input");
            }
            
            for(int spacesCounter = 0; spacesCounter < (n - row); spacesCounter++) {
                spaces.append(" ");
            }
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return spaces.toString();
    }

    /**
     * Provide Numbers for the Pattern
     * @param row String
     * @param n String
     * @return String of Numbers in Pattern
     */
    public String numbers(int row, int n){
        StringBuilder numbers = new StringBuilder();
        try{
            n = Integer.parseInt(n + "");
            row = Integer.parseInt(row + "");
            if(n < 1) {
                throw new Exception("Input Must Be Greater Than Zero");
            }
            if(row > n) {
                throw new Exception("Row must be smaller than input");
            }
            for(int numberCounter = 1; numberCounter <= row; numberCounter++) {
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
