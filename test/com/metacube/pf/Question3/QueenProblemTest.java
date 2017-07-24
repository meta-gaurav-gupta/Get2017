package com.metacube.pf.Question3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class QueenProblemTest {

    /**
     * Test of nQueen method, of class QueenProblem.
     */
    @Test
    public void testNQueen() {
        
        //Positive Test Case
        int[][] board = new int [][] {
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0},
            { 0,  0,  0,  0} 
        };
        int startRow = 0;
        int dimensionOfMatrix = 4;
        QueenProblem instance = new QueenProblem();
        boolean expResult = true;
        boolean result = instance.nQueen(board, startRow, dimensionOfMatrix);
        assertEquals(expResult, result);
        
        //Negative Test Case
        board = new int [0][0];
        dimensionOfMatrix = 0;
        expResult = false;
        result = instance.nQueen(board, startRow, dimensionOfMatrix);
        assertEquals(expResult, result);
    }
    
}
