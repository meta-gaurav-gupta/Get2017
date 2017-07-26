
package com.metacube.oops;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class ParticipantTest {
        /**
     * Test of getSingleSelectAnswer method, of class Participant.
     */
    @Test
    public void testGetSingleSelectAnswer() {
        //Positive Test Case
        Participant instance = new Participant();
        Answer answer = new Answer();
        answer.setAnswer("1");
        answer.setQuestionId(0);
        instance.putAnswer(answer);
        String expResult = "1";
        String result = instance.getSingleSelectAnswer();
        System.out.println(result);
        assertEquals(expResult, result);
        
        //Negative Test Case
        instance = new Participant();
        answer = new Answer();
        answer.setAnswer("1");
        answer.setQuestionId(4);
        instance.putAnswer(answer);
        expResult = null;
        result = instance.getSingleSelectAnswer();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of getAnswersList method, of class Participant.
     */
    @Test
    public void testGetAnswersList() {
        //Negative Test Case - When No answers are stored
        Participant instance = new Participant();
        ArrayList<Answer> expResult = new ArrayList<>();
        ArrayList<Answer> result = instance.getAnswersList();
        assertEquals(expResult, result);
        
        //Positive Test Case
        Answer answer = new Answer();
        answer.setAnswer("5");
        answer.setQuestionId(0);
        instance.putAnswer(answer);
        expResult = new ArrayList<>();
        expResult.add(answer);
        result = instance.getAnswersList();
        assertEquals(expResult, result);
    }
    
}
