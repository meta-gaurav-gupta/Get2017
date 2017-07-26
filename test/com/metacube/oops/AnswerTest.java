
package com.metacube.oops;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class AnswerTest {
    /**
     * Test of getAnswer method, of class Answer.
     */
    @Test
    public void testGetAnswer() {
        Answer instance = new Answer();
        instance.setAnswer("hello");
        String expResult = "hello";
        String result = instance.getAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuestionId method, of class Answer.
     */
    @Test
    public void testGetQuestionId() {
        Answer instance = new Answer();
        instance.setQuestionId(0);
        int expResult = 0;
        int result = instance.getQuestionId();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAnswer method, of class Answer.
     */
    @Test
    public void testValidateAnswer_3args() {
        //Positive Test Case
        String answer = "hello";
        int questionId = 1;
        String question = "hello world";
        boolean expResult = true;
        boolean result = Answer.validateAnswer(answer, questionId, question);
        assertEquals(expResult, result);
        
        //Negative Test Case
        answer = "7";
        questionId = 0;
        question = "1/2/3/4/5";
        expResult = false;
        result = Answer.validateAnswer(answer, questionId, question);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAnswer method, of class Answer.
     */
    @Test
    public void testValidateAnswer_String_int() {
        //Positive Test Case
        String answer = "hello";
        int questionId = 1;
        boolean expResult = true;
        boolean result = Answer.validateAnswer(answer, questionId);
        assertEquals(expResult, result);
        
        //Negative Test Case
        answer = "One";
        questionId = 0;
        expResult = false;
        result = Answer.validateAnswer(answer, questionId);
        assertEquals(expResult, result);
    }
    
}
