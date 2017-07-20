
package com.metacube.pf.Question1;

/**
 *
 * @author Gaurav
 */
public class LargestDigit {
    
    /**
     * Find Largest Digit in a number
     * @param x Integer Number
     * @return Integer - Largest Digit
     */
    int largestDigit(int x) {
        try {
            x = Integer.parseInt(String.valueOf(x));
            if (Math.abs(x) == 0) {
                return 0;
            }
            int max = Math.abs(x) % 10;  //  take last digit as maximum digit
            int checking = largestDigit(Math.abs(x) / 10);
            if (max < checking) {
                max = checking;
            }

            return max;
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            // Return 0 if the program has exception
            return 0;
        }
    }
}
