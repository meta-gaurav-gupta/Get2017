
package com.metacube.pf.Question3;

/**
 *
 * @author Gaurav
 */
public class QueenProblem {
    /**
    * 
    * method checks that a position of queen in given board if it is safe or not
    *  
    * @param board Integer Array
    * @param row Integer
    * @param col Integer
    * @param dimesionMatrix Integer
    * @return boolean true -> safe, false -> not safe
    */
    private boolean boxSafe(int[][] board, int row, int col, int dimesionMatrix) {

    /* Check this row on left side */
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1){
                return false;
            }
        }

        /* Check upper diagonal on left side */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1){
                return false;
            }
        }

        /* Check lower diagonal on left side */
        for (int i=row, j=col; j>=0 && i<dimesionMatrix; i++, j--) {
            if (board[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    /**
     * Utility method for nQueen method
     */
    private boolean  nQueenUtil(int[][] board, int startRow, int dimensionOfMatrix) {
        boolean result = false;
        if (startRow == dimensionOfMatrix) {
            result = true;
        }
        else{
            for (int boardLoop = 0; boardLoop < dimensionOfMatrix; boardLoop++ ) {
                if(boxSafe(board, boardLoop , startRow, dimensionOfMatrix) == true) {
                    board[boardLoop][startRow] = 1;

                    /* recur to place rest of the queens */
                    if (nQueenUtil(board, startRow + 1, dimensionOfMatrix) == true){
                        result = true;
                        break;
                    }

                    /* If placing queen in board[i][col]
                       doesn't lead to a solution then
                       remove queen from board[i][col] */
                    board[boardLoop][startRow] = 0; // BACKTRACK
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * Method check for the arrangement of n queens
     * @param board Integer Array
     * @param startRow Integer
     * @param dimensionOfMatrix Integer
     * @return boolean true -> queens can be placed, false -> if not
     */
    public boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix){
        boolean result = false;
        try{
            if(board.length == 0){
                throw new Exception("Board Must Not Be Empty");
            }
            if(dimensionOfMatrix == 0){
                throw new Exception("Dimension Of Matrix Must Be A Positive Number");
            }
            if(startRow > dimensionOfMatrix){
                throw new Exception("Starting Row Must Be In Range Of The Dimension Of Matrix");
            }
            result = nQueenUtil(board, startRow, dimensionOfMatrix);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
