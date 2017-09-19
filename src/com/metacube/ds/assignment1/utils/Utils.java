package com.metacube.ds.assignment1.utils;

import java.util.Scanner;

/**
 *
 * @author Gaurav
 */
public class Utils {
    private static Scanner in = new Scanner(System.in);
    
    /**
     * Take integer as input.
     *
     * @param message display to user
     * @return the integer
     */
    public static int takeIntegerAsInput(String message) {
        boolean flag = true;
        int input = 0;
        String temp = "";
        while (flag) {
            try {
                temp = in.nextLine().trim();
                input = Integer.parseInt(temp);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a valid " + message);
            }
        }
        return input;
    }
    
    /**
     * Take String as input.
     *
     * @return the String
     */
    public static String takeStringAsInput() {
        String input = "";
        input = in.nextLine().trim();
        return input;
    }
    
    /**
     * Take integer as input.
     *
     * @return the integer
     */
    public static int takePositiveIntegerAsInput() {
        boolean flag = true;
        int input = 0;
        String temp = "";
        while (flag) {
            try {
                temp = in.nextLine().trim();
                input = Integer.parseInt(temp);
                if(input <= 0){
                    throw new IllegalArgumentException();
                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a valid integer");
            } catch (IllegalArgumentException ex) {
                System.out.println("Please Enter input more than 0");
            }
                
        }
        return input;
    }
}
