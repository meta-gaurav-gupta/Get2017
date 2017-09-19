package com.metacube.ds.assignment2.utils;

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
    
    /**
     * Assigns the specified integer value to each element of the specified array
     * of integers.
     *
     * @param array the array to be filled
     * @param value the value to be stored in all elements of the array
     */
    public static void fill(int[] array, int value) {
        for (int i = 0, len = array.length; i < len; i++) {
            array[i] = value;
        }
    }
    
    /**
     * Copy one array into another
     * @param target integer array to be pasted
     * @param source integer array to be copied
     */
    public static void arrayCopy(int[] target, int[] source){
        for(int index = 0; index < source.length; index++){
            target[index] = source[index];
        }
    }
}
