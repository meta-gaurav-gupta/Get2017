/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.oops;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class QuestionTest {
    /**
     * Test of getQuestions method, of class Question.
     */
    @Test
    public void testGetQuestions() {
        //Positive Test Case
        Question instance = new Question();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Q1. Overall Rating, Single Select, 1/2/3/4/5");
        expResult.add("Q2. Area of improvement, Multi Select, Service Quality/Communication/Delivery Process");
        expResult.add("Q3. Work progress, Text");
        expResult.add("Q4. No of person enrolled, Number");
        expResult.add("Q5. Feedback, Text");
        String path = "C:/Users/User/Documents/NetBeansProjects/OOPSAssignment2/src/com/metacube/oops/input.txt";
        ArrayList<String> result = instance.getQuestions(path);
        assertEquals(expResult, result);
        
        //Negative Test Case
        expResult = new ArrayList<>();
        path = "";
        result = instance.getQuestions(path);
        assertEquals(expResult, result);
    }
    
}
