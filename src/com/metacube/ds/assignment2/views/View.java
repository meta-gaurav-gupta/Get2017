package com.metacube.ds.assignment2.views;

import com.metacube.ds.assignment2.collection.EmployeeCollection;
import com.metacube.ds.assignment2.entity.Employee;
import com.metacube.ds.assignment2.entity.NameComparator;
import com.metacube.ds.assignment2.utils.Utils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class View {
    
    /**
     * Initialize view
     */
    public void init(){
        EmployeeCollection collection = new EmployeeCollection();
        Iterator itr;
        while(true){
            printMainMenu();
            System.out.println("\nEnter Valid Choice:");
            int choice = Utils.takeIntegerAsInput("choice");
            switch(choice){
            case 1:
                if(!collection.add(createEmployee())) {
                    System.out.println("Duplicate Entry");
                }
                break;
            case 2:
                System.out.println("List Of Employees: ");
                itr = collection.iterator();
                while(itr.hasNext()){
                    System.out.println(itr.next().toString());
                }
                break;
            case 3:
                System.out.println("Sorted List Based On Names: ");
                List<Employee> list = collection.toList();
                Collections.sort(list, new NameComparator());
                itr = list.iterator();
                while(itr.hasNext()){
                    System.out.println(itr.next().toString());
                }
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Please Enter a valid option");
            }
        }
    }
    
    /**
     * Print Main Menu Items
     */
    private void printMainMenu() {
        System.out.println("1 Add an employee");
        System.out.println("2 List of employees");
        System.out.println("3 Sort employee on the basis of there names");
        System.out.println("4 to exit");
    }
    
    /**
     * Create Employee by getting information from user
     * @return Employee 
     */
    private Employee createEmployee(){
        Employee employee = new Employee();
        System.out.println("Enter Employee Id: ");
        int id = Utils.takeIntegerAsInput("id");
        System.out.println("Enter Employee Name: ");
        String name = Utils.takeStringAsInput();
        System.out.println("Enter Employee Address: ");
        String address = Utils.takeStringAsInput();
        employee.setEmpId(id);
        employee.setEmpName(name);
        employee.setAddress(address);
        return employee;
    }

}
