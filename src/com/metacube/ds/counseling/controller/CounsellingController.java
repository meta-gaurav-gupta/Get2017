package com.metacube.ds.counseling.controller;

import com.metacube.ds.counseling.facade.CounselingFacade;
import com.metacube.ds.queue.Queue;

/**
 *
 * @author Gaurav
 */
public class CounsellingController {

    /**
     * Do allotment.
     * 
     * Print the allotment result
     */
    public void doAllotment(){
        CounselingFacade council = CounselingFacade.getInstance();
        council.getAllCollege();
        council.getAllStudent();
        Queue<String> result = council.allotSeats();
        while(result.size() > 0){
                System.out.print(result.dequeue());
        }
    }
}
