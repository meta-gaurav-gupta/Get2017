package com.metacube.pf.Question1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * fact -If the legend were true, and if the priests were able to move disks at
 * a rate of one per second, using the smallest number of moves, it would take
 * them 264 − 1 seconds, or roughly 585 billion years to finish,[3] which is 
 * about 42 times the current age of the Universe.
 * 
 * Class take a source , destination and Auxiliary pillar as String and an 
 * integer number of disk and returns the List of Strings that tells the moves 
 * to move all the disks from source to Destination pillar
 * 
 * @author Gaurav
 */
public class TowerOfHanoi {
    static int totalDisks;  
    
    /**
     * Utility Method for towerOfHanoi method
     */
    private List<String> towerOfHanoiUtil(String source, String destination, String temp, int numOfDisk)
    {
        if(totalDisks == 0){
            totalDisks = numOfDisk;
        }
        List<String> listWords = new ArrayList<>();

        if(numOfDisk == 1) {
            listWords.add("Move Disk "+(totalDisks + 1 - numOfDisk) + " from " + source + " to " + destination);
            return listWords;
        }

        listWords.addAll(towerOfHanoiUtil(source, temp, destination, numOfDisk - 1)); 
        listWords.add("Move Disk " + (totalDisks + 1 - numOfDisk) + " from " + source + " to " + destination);
        listWords.addAll(towerOfHanoiUtil(temp, destination, source, numOfDisk - 1)); 
        
        return listWords;
    }
    
    /**
     * Recursive Method to return the movement of the disks until completion 
     * @param source String starting tower
     * @param destination String ending tower
     * @param temp String aux tower
     * @param numOfDisk Integer No of disk in tower
     * @return List of String list of movements of the disks
     */
    public List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
    {
        List<String> resultList = new ArrayList<>();
        try {
            numOfDisk = Integer.parseInt(numOfDisk + "");
            if(numOfDisk == 0){
                throw new Exception("Number Of Disk Must Be A Positive Number");
            }
            if(source.length() == 0 || destination.length() == 0 || temp.length() == 0){
                throw new Exception("Name Of The Disks Must Be A Valid Input");
            }
            resultList = towerOfHanoiUtil(source, destination, temp, numOfDisk);
            
        } catch(NumberFormatException e){
            resultList = null;
            System.out.println(e.getMessage());
        } catch(Exception e){
            resultList = null;
            System.out.println(e.getMessage());
        }
        return resultList;
    }
    
}
