
package com.metacube.oops.Question2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class MatrixTest {

    /**
     * Test of addElement method, of class Matrix.
     */
    @Test
    public void testAddElement() {
        //Positive Test Case
        int xDimension = 3;
        int yDimension = 3;
        int row = 0;
        int col = 0;
        int value = 5;
        Matrix instance = new Matrix(xDimension, yDimension);
        int expResult = 5;
        int result = instance.addElement(row, col, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of show method, of class Matrix.
     */
    @Test
    public void testShow() {
        //Positive Test Case
        int xDimension = 3;
	int yDimension = 3;
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}
                         };
        Matrix instance = new Matrix(xDimension, yDimension);
        int[][] expResult = {{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}
                            };
        int[][] result = instance.show(matrix);
        assertArrayEquals(expResult, result);
        
        //Negative Test Case
        yDimension = 2;
        instance = new Matrix(xDimension, yDimension);
        matrix = new int[][]{{1, 2},
                             {4, 5}
                            };
        expResult = new int [][]{{1, 2},
                                 {5, 5}
                                };
        assertNotEquals(expResult, instance.show(matrix));
    }

    /**
     * Test of transposeMatrix method, of class Matrix.
     */
    @Test
    public void testTransposeMatrix() {
        //Positive Test Case
        int rowsInMatrix = 3;
        int colsInMatrix = 3;
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}
                         };
        int[][] expResult = {{1, 4, 7},
                             {2, 5, 8},
                             {3, 6, 9}
                            };
        Matrix instance = new Matrix(rowsInMatrix, colsInMatrix);
        int[][] result = instance.transposeMatrix(matrix, rowsInMatrix, colsInMatrix);
        assertArrayEquals(expResult, result);
        
        //Negative Test Case
        rowsInMatrix = 2;
        colsInMatrix = 2;
        instance = new Matrix(rowsInMatrix, colsInMatrix);
        matrix = new int[][]{{1, 2},
                             {4, 5}
                            };
        expResult = new int [][]{{1, 2},
                                 {5, 5}
                                };
        assertNotEquals(expResult, instance.show(matrix));
    }

    /**
     * Test of multiplyMatrix method, of class Matrix.
     */
    @Test
    public void testMultiplyMatrix() {
        //Positive Test Case
        int xDimension = 2;
        int yDimension = 2;
        int[][] firstMatrix = new int[][]{{1, 2},
                                          {3, 4}
                                         };
        int[][] secondMatrix = new int[][]{{4, 3},
                                           {2, 1}
                                          };
        Matrix instance = new Matrix(xDimension, yDimension);
        int[][] expResult = new int[][]{{8, 5},
                                        {20, 13}
                                       };
        int[][] result = instance.multiplyMatrix(firstMatrix, secondMatrix);
        assertArrayEquals(expResult, result);
        
        //Negative Test Case
        xDimension = 1;
        yDimension = 1;
        instance = new Matrix(xDimension, yDimension);
        firstMatrix = new int[][]{{1}};
        secondMatrix = new int[][]{{4}};
        expResult = new int[][]{{6}};
        result = instance.multiplyMatrix(firstMatrix, secondMatrix);
        assertNotEquals(expResult, result);
    }
    
}
