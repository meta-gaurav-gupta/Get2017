package com.metacube.ds.assignment2.sort;

import com.metacube.ds.assignment2.enums.SortType;

/**
 *
 * @author Gaurav
 */
public interface Sort {
    
    /**
     * Sort function to be override by the child class
     * @param numbers integer array to be sorted
     * @return Sort Type(Enumeration) type of sorting technique is used to sort the array
     */
    public SortType sort(int[] numbers);
    
}
