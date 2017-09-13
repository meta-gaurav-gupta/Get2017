/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.ds.assignment1.controller;

import com.metacube.ds.assignment1.entity.Job;
import com.metacube.ds.assignment1.enums.Priorities;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class ControllerTest {
    /**
     * Test of remove method, of class Controller.
     */
    @Test
    public void testRemove() {
        //Positive Test Case
        Controller controller = new Controller();
        controller.addJob("test1.txt", Priorities.GRADUATE);
        controller.addJob("test2.txt", Priorities.UNDERGRADUATE);
        controller.addJob("test3.txt", Priorities.CHAIRMAN);
        controller.addJob("test4.txt", Priorities.PROFESSOR);
        Job expResult = new Job("test3.txt", 1);
        Job result = controller.remove();
        assertEquals(expResult.getPriority(), result.getPriority());
        
        controller.remove();
        controller.remove();
        controller.remove();
        
        //Negative Test Case (Empty Case)
        expResult = null;
        result = controller.remove();
        assertEquals(expResult, result);
    }
}
