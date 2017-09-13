package com.metacube.ds.assignment1.view;

import com.metacube.ds.assignment1.controller.Controller;
import com.metacube.ds.assignment1.entity.Job;
import com.metacube.ds.assignment1.enums.Priorities;
import com.metacube.ds.assignment1.utils.Utils;

/**
 *
 * @author Gaurav
 */
public class View {
    
    private Controller controller;

    public View() {
        controller = new Controller();
    }
    
    /**
     * Initialize view
     */
    public void init(){
        while(true){
            printMainMenu();
            System.out.println("\nEnter Valid Choice:");
            /*take the user choice*/
            int choice = Utils.takeIntegerAsInput();
            switch(choice){
            /*For assigning a task*/
            case 1:
                System.out.println("Enter Document Name To Print: ");
                controller.addJob(Utils.takeStringAsInput(), getDepartment());
                break;
            /*For completing the jobs*/
            case 2:
                for(Job job : controller.executeJobs()){
                    System.out.println(job.toString());
                }
                System.out.println("All jobs are completed ");
                break;
            /*In case of exit*/
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Please Enter a valid option");
            }
        }
    }
    
    /**
     * Return the Priority 
     * @return Priority
     */
    private Priorities getDepartment(){
        for(String menu : controller.getDepartmentMenu()){
            System.out.println(menu);
        }
        System.out.println("\nEnter Valid Department:");
        Priorities result = null;
        do{
            
            /*take the user choice*/
            int choice = Utils.takeIntegerAsInput();
            switch(choice){
            /*For assigning a task*/
            case 1:
                result = Priorities.CHAIRMAN;
                break;
            /*For completing the jobs*/
            case 2:	
                result = Priorities.PROFESSOR;
                break;
            /*In case of exit*/
            case 3:
                result = Priorities.GRADUATE;
                break;
            case 4:
                result = Priorities.UNDERGRADUATE;
                break;
            default:
                System.out.println("Please Enter a valid option");
            }
        }while(result == null);
        return result;
    }
    
    /**
     * Print Main Menu Items
     */
    private void printMainMenu(){
        for(String menu : controller.getMainMenu()){
            System.out.println(menu);
        }
    }
}
