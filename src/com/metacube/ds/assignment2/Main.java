package com.metacube.ds.assignment2;

import com.metacube.ds.assignment2.enums.SortType;
import com.metacube.ds.assignment2.sort.ComparisonSort;
import com.metacube.ds.assignment2.sort.LinearSort;
import com.metacube.ds.assignment2.sort.Sort;
import com.metacube.ds.assignment2.utils.Utils;
import java.util.Arrays;

/**
 *
 * @author Gaurav
 */
public class Main {
    
    public static void main(String[] args) {
        int choice;
        int size;
        int[] input = null;
        Sort sort;
        SortType sortType;
        while(true) {
            displayMenu();
            choice = Utils.takeIntegerAsInput("Choice ");
            switch(choice) {
            case 1:
                System.out.println("Enter Size Of Array");
                size = Utils.takePositiveIntegerAsInput();
                input = new int[size];
                for(int index = 0 ; index<size ; index++) {
                    System.out.println("Enter element");
                    input[index] = Utils.takeIntegerAsInput("" + (index+1) + " Element ");
                }
                break;
            case 2:
                    sort = new ComparisonSort();
                    sortType = sort.sort(input);
                    displayOutput(sortType, input);
                    break;
            case 3:
                    sort = new LinearSort();
                    sortType = sort.sort(input);
                    displayOutput(sortType, input);
                    break;
            case 4:
                    System.exit(0);
            default :

            }
        }
    }
    
    private static void displayMenu(){
        System.out.println("Please Enter Valid Choice: ");
        System.out.println("\n1. Enter Array");
        System.out.println("2. Comparison Sort");
        System.out.println("3. Linear Sort");
        System.out.println("4. Exit\n");
    }
    
    private static void displayOutput(SortType type, int[] numbers){
        System.out.println("System has used " + type + " sorting technique and sorted list as below :");
        System.out.println(Arrays.toString(numbers));
    }
    
}
