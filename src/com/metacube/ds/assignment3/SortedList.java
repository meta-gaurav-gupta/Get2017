package com.metacube.ds.assignment3;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class SortedList {
    
    private List<Integer> sortedList;

    public SortedList() {
        sortedList = new LinkedList<>();
    }
    
    private int position = 0;

    /**
     * Gets the position.
     * Change the position where the data can be inserted
     * 
     * @param data the data
     */
    private void getPosition(int data){
        
        if(position < sortedList.size()) {
            int compare = sortedList.get(position).compareTo(data);
            if(compare < 0){
                position++;
                getPosition(data);
            }
        }
    }

    /**
     * Adds the.
     * This method add the specified data in list
     * @param data the data
     */
    public void add(int data){
        
        getPosition(data);
        if(position < sortedList.size()) {
            sortedList.add(position,data);
        } else {
            sortedList.add(data);
        }
        position = 0;

    }

	

}
