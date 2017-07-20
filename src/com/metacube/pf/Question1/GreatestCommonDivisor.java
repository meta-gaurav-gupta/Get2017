
package com.metacube.pf.Question1;

/**
 *
 * @author Gaurav
 */
public class GreatestCommonDivisor {
    /**
     * Calculate Greatest Common Divisor of two given numbers
     * @param x Integer
     * @param y Integer
     * @return Integer Greatest Common Divisor
     */
    int calculateGcd(int x, int y){
        try {
            x = Integer.parseInt(String.valueOf(x));
            y = Integer.parseInt(String.valueOf(y));
            if (Math.abs(x) < Math.abs(y)) {
                /* if first number is less than second , then swap the numbers */
                x = Math.abs(x) + Math.abs(y);
                y = Math.abs(x) - Math.abs(y);
                x = Math.abs(x) - Math.abs(y);
            }
            if (Math.abs(x) % Math.abs(y) == 0) {
                return Math.abs(y);
            }
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
	return calculateGcd(Math.abs(y), Math.abs(x % y));
    }
}
