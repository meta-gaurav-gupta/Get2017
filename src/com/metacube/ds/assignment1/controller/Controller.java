package com.metacube.ds.assignment1.controller;

import com.metacube.ds.assignment1.entity.Job;
import com.metacube.ds.assignment1.entity.PriorityQueue;
import com.metacube.ds.assignment1.enums.Priorities;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Gaurav
 */
public class Controller {
    
    /**
     * Priority Queue to store jobs
     */
    private PriorityQueue<Job> jobs;

    /**
     * Constructor
     */
    public Controller() {
        jobs = new PriorityQueue<>();
    }
    
    /**
     * Add Job to the priority queue
     * @param document String name of the document to print
     * @param priority Priority of the job
     */
    public void addJob(String document, Priorities priority){
        Job job = new Job(document, getPriority(priority));
        jobs.insert(job);
    }
    
    /**
     * Returns the respective numerical priority of the enumerated priorities 
     * @param priority Priority of job
     * @return integer respective priority integer
     */
    private int getPriority(Priorities priority){
        int result = 0;
        switch(priority){
            case CHAIRMAN:
                result = 1;
                break;
            case PROFESSOR:
                result = 2;
                break;
            case GRADUATE:
                result = 3;
                break;
            case UNDERGRADUATE:
                result = 4;
                break;
        }
        return result;
    }
    
    /**
     * Remove job from the priority queue - Complete the task
     * @return Job which is executed
     */
    public Job remove() {
        return jobs.remove();
    }
    
    /**
     * Returns the list of the menu items for the main menu
     * @return List of String menu items
     */
    public List<String> getMainMenu() {
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("1. Insert New Job");
        menuItems.add("2. Print Jobs In Queue");
        menuItems.add("3. Exit");
        
        return menuItems;
    }
    
    /**
     * Returns the list of the menu items for the department menu
     * @return List of String menu items
     */
    public List<String> getDepartmentMenu() {
        List<String> menuItems = new ArrayList<>();
        menuItems.add("1. Chairman");
        menuItems.add("2. Professor");
        menuItems.add("3. Graduate");
        menuItems.add("4. Under Graduate");
        
        return menuItems;
    }
    
    /**
     * Returns the list of the completed jobs
     * @return List of String jobs
     */
    public List<Job> executeJobs(){
        List<Job> completedJobs = new ArrayList<>();
        while(jobs.size() > 0){
            completedJobs.add(jobs.remove());
        }
        
        return completedJobs;
    }
}
