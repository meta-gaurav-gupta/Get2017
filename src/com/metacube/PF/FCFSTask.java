package com.metacube.PF;


/**
 * PFAssignment4 - Simulation Of FCFS (First Come First Serve) Job Scheduling 
 * @author User
 */
public class FCFSTask {
    /**
     * 
     * @param arrival_time integer array
     * @param job_size integer array
     * @return 2d integer array full scheduling information
     */
    public int [][] FCFS( int[] arrival_time, int[] job_size ) {
        int[][] resultArray = new int[arrival_time.length][5];
        for(int index = 0 ; index < arrival_time.length ; index++) {
            resultArray[index][0] = index + 1;
            resultArray[index][1] = arrival_time[index];
            if(index == 0) {
                resultArray[index][2] = 0;
            }else if(index != 0 && resultArray[index-1][4] > arrival_time[index] ) {
                resultArray[index][2] = resultArray[index-1][4] - arrival_time[index] + 1;
            }else {
                resultArray[index][2] = 0;
            }
            if(index == 0) {
                resultArray[index][3] = arrival_time[index];
            }else if(index != 0 && resultArray[index-1][4] > arrival_time[index] ){
                resultArray[index][3] = resultArray[index-1][4] + 1;
            }else {
                resultArray[index][3] = arrival_time[index];
            }

            if(index == 0) {
                resultArray[index][4] = resultArray[index][3] + job_size[index] - 1;
            }else {
                resultArray[index][4] = resultArray[index][3] + job_size[index] - 1;
            }
        }
        
        return resultArray;
    }
}
