package com.metacube.ds.assignment2.entity;

/**
 *
 * @author Gaurav
 */
public class Employee implements Comparable<Employee>{
    
    private int empId;
    private String empName;
    private String address;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int compareTo(Employee emp) {
        return getEmpId() - emp.getEmpId();
    }
    
    @Override
    public String toString() {
        return "Name = " + empName + "\t ID = " + empId + "\t Address = " + address;
    }
    
}
