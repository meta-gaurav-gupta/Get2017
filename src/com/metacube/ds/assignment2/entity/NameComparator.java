package com.metacube.ds.assignment2.entity;

import java.util.Comparator;

/**
 *
 * @author Gaurav
 */
public class NameComparator implements Comparator<Employee>{

    /**
     * Compares its two arguments for order.
     *
     * @param emp1 the first employee to be compared.
     * @param emp2 the second employee to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first employee is less than, equal to, or greater than the
     *         second.
     */
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getEmpName().compareTo(emp2.getEmpName());
    }
    
}
