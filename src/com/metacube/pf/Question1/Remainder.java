package com.metacube.pf.Question1;
/**
 *
 * @author Gaurav
 */
public class Remainder {
    
    /**
     * Remainder = Numerator % Denominator 
     * @param x Integer - Numerator 
     * @param y Integer - Denominator 
     * @return Integer - Remainder
     */
    public int rem(int x, int y) {
		try {
			if(y == 0) {
				throw new ArithmeticException("Denominator Must Not Be 0"); // to throws an exception when y is equal to 0
			}
			if (x > 0 && y > 0) {
				/* Case when x is greater than 0 and y is also greater than 0*/
				if (x >= y) {
					x = x - y;
					return rem(x, y);
				}
			} else if (x < 0 && y > 0) {
				/* Case when x is less than 0 and y is also greater than 0*/
				if(Math.abs(x) >= y) {
					x = x + y;
					return rem(x, y);
				} 
			} else if (x < 0 && y < 0) {
				/* Case when x is greater than 0 and y is also greater than 0*/
				if(Math.abs(x) >= Math.abs(y)) {
					x = x + Math.abs(y);
					return rem(x, y);
				} 
			} else if (x > 0 && y < 0) {
				if(x >= Math.abs(y)) {
					x = x + y;
					return rem(x, y);
				} 
			}
		} catch (ArithmeticException e) {
			 System.out.println("Caught: " + e.getMessage());
		}
		return x;
	}
}

