
package com.metacube.oops;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 */
public class Utils {
    
    /**
     * Takes Integer Input and validate it
     * @param message String 
     * @return Integer
     */
    public static int takeIntegerInput(String message){
        Scanner input = new Scanner(System.in);
        int inputNumber;
        while(true){
            try{
                System.out.println(message);
                inputNumber = input.nextInt();
                if(inputNumber <= 0){
                    throw new IllegalArgumentException("Input Must Be A Positive Number");
                }
                break;
            }catch(InputMismatchException | IllegalArgumentException ex){
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        }
        return inputNumber;
    }
    
    /**
     * Take Integer Input In Range
     * @param start Integer
     * @param end Integer
     * @return Integer
     */
    public static int takeIntegerInput(int start, int end){
        Scanner input = new Scanner(System.in);
        int inputNumber;
        while(true){
            try{
                System.out.println("Enter A Valid Option: ");
                inputNumber = Integer.parseInt(input.next());
                if(inputNumber <= 0 ){
                    throw new IllegalArgumentException("Input Must Be A Positive Number");
                }
                if( inputNumber < start || inputNumber > end){
                    throw new IllegalArgumentException("Selected Option Must Be In Between " + start + " - " + end);
                            
                }
                break;
            }catch(IllegalArgumentException ex){
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        }
        return inputNumber;
    }
    
    /**
     * Take Valid Product Which Exits In The File
     * @return Integer
     */
    public static int inputValidProduct(){
        ArrayList<String> products = ReadCSV.getProductsFromCSV();
        Scanner input = new Scanner(System.in);
        int productCode;
        while(true){
            boolean flag = false;
            try{
                System.out.println("Enter A Valid Product : ");
                productCode = Integer.parseInt(input.next());
                for(String product : products){
                    String attributes[] = product.split(",");
                    if(attributes[0].contains(productCode+"")){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    throw new IllegalArgumentException("Not A Valid Product Code");
                }
                else{
                    break;
                }
            }catch(IllegalArgumentException ex){
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        }
        return productCode;
    }
}
