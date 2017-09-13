package com.metacube.ds.assignment1.entity;

/**
 *
 * @author Gaurav
 * @param <T> the type of elements held in this collection
 */
public class Job<T> implements Comparable<Job>{
    
    private String document;
    private int priority;

    public void setDocument(String document) {
        this.document = document;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDocument() {
        return document;
    }

    public int getPriority() {
        return priority;
    }
    
    /** Constructor
     * @param document
     * @param priority 
     **/
    public Job(String document, int priority) {
        this.document = document;
        this.priority = priority;
    }

    /** toString()
     * @return  
     **/
    @Override
    public String toString() {
        return "Document Name : "+ document +"\tPriority : "+ priority;
    }

    /**
     * Compare To
     * @param job
     * @return integer
     */
    @Override
    public int compareTo(Job job) {
        return (this.priority < job.priority) ? -1 : ((this.priority == job.priority) ? 0 : 1);
    }
}
