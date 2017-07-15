package com.metacube.PF;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.metacube.PF.FCFSTask;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class FCFSTaskTest {
    
     /**
     * Test of FCFS method, of class FCFSTask.
     */
    @Test
    public void testFCFS() {
        System.out.println("FCFS");
        int[] arrival_time_positive = {1, 5, 9, 25};
        int[] job_size_positive = {12,7,2,5};
        int[] arrival_time_negative = {7, 2, 1, 5, 8};
        int[] job_size_negative = {2, 3, 0, 9, 4};
        FCFSTask instance = new FCFSTask();
        int[][] expResult_positive = {{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
        int[][] expResult_negative = {{3,2,4,9,6},{4,7,8,5,6},{7,4,1,8,5},{3,6,9,2,5}};
        int[][] result = instance.FCFS(arrival_time_positive, job_size_positive);
        assertArrayEquals(expResult_positive, result);                                     //Positive Test Case
        result = instance.FCFS(arrival_time_negative, job_size_negative);
        assertNotEquals(expResult_negative, result);                                        //Negative Test Case
    }
    
}
