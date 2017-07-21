package com.metacube.oops.Question2;

/**
 *
 * @author Gaurav
 */
public class Matrix {
    int[][] matrix;

    /**
     * Class Matrix Constructor
     * @param Integer row
     * @param Integer column
     */
    Matrix(int row, int col){
        matrix = new int[row][col];
    }

    /** 
     * add an Element in Matrix
     * @param Integer row
     * @param Integer column
     * @param Integer value
     * @return Integer - Added Element
     */
    int addElement(int row, int col, int value) {
        matrix[row][col] = value;

        return matrix[row][col];
    }

    /**
     * 
     * @param Integer Array matrix
     * @return Integer Array
     */
    int[][] show(int[][] matrix){
        return matrix;
    }

    /**
     * Transpose of Matrix
     * @param Integer Array matrix
     * @param Integer rowsInMatrix
     * @param Integer colsInMatrix
     * @return Integer Array Transposed Matrix
     */
    int[][] transposeMatrix(int matrix[][], int rowsInMatrix, int colsInMatrix){
        int[][] tempMatrix = new int[colsInMatrix][rowsInMatrix];

        for (int row = 0; row < rowsInMatrix ; row++) {
            for (int col = 0; col < rowsInMatrix; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for (int row = 0; row < colsInMatrix; row++) {
            for (int col = 0; col < rowsInMatrix; col++) {
                tempMatrix[row][col] = matrix[col][row];
            }
        }

        return tempMatrix;
    }

    /**
     * Multiply two matrix
     * 
     * @param Integer Array firstMatrix
     * @param Integer Array secondMatrix
     * @return Integer Array Resultant Matrix of two given Matrices 
     */
    int[][] multiplyMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];

        try {

            if(firstMatrix[0].length != secondMatrix.length) {
                throw new Exception("Number of Rows in First Matrix must bes equal to Number of Colums in Second Matrix ");
            }

        }catch (Exception notEqualError) {
            System.out.println(notEqualError.getMessage());
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[0].length ; col++) {
                int sum = 0;

                for (int k = 0; k < secondMatrix.length ; k++) {
                    sum += firstMatrix[row][k]*secondMatrix[k][col];
                }

                resultMatrix[row][col] = sum;
            }
        }

        return resultMatrix;
    }
}
