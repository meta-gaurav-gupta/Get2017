/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.counseling.entity;

/**
 *
 * @author Gaurav
 */
public class Colleges {
    
    private String name;

    private int seats;

    private int rank;
    
    private static int totalSeats;

    /**
     * Instantiates a new colleges.
     */
    public Colleges() {

    }

    /**
     * Instantiates a new colleges.
     *
     * @param name the name
     * @param seats the seats
     * @param rank the rank
     */	
    public void addCollegeDetail(String name,int rank,int seats){
        this.setName(name);
        this.setRank(rank);
        this.setSeats(seats);
        totalSeats += seats;
    }

    /**
     * Gets the rank.
     *
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets the rank.
     *
     * @param rank the new rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the seats.
     *
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the seats.
     *
     * @param seats the new seats
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }
    /**get total
     * 
     * @return the total number of seats
     */
    public static int getTotal(){
        return totalSeats;
    }
}
