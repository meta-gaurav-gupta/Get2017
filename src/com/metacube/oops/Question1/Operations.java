package com.metacube.oops.Question1;

/**
 *
 * @author Gaurav
 */
public interface Operations {
    /**
     * prototype of add operation of calculator
     * 
     * @param firstOperand double 
     * @param secondOperand double
     * @return double Addition of firstOperand and secondOperand
     */
    public double addOperation(double firstOperand, double secondOperand);

    /**
     * prototype of subtract operation of calculator
     * 
     * @param firstOperand double
     * @param secondOperand double
     * @return double subtraction of firstOperand and secondOperand
     */
    public double subtractOperation(double firstOperand, double secondOperand);

    /**
     * prototype of multiplication operation of calculator
     * 
     * @param firstOperand double
     * @param secondOperand double
     * @return double multiplication of firstOperand and secondOperand
     */
    public double multiplicationOperation(double firstOperand, double secondOperand);

    /**
     * prototype of division operation of calculator
     * 
     * @param firstOperand double
     * @param secondOperand double
     * @return double division of firstOperand and secondOperand
     */
    public double divisionOperation(double firstOperand, double secondOperand);

    /**
     * prototype of modulus operation of calculator
     * 
     * @param firstOperand double
     * @param secondOperand double
     * @return double modulus of firstOperand and secondOperand
     */
    public double modOperation(double firstOperand, double secondOperand);

    /**
     * prototype of negation operation of calculator
     * 
     * @param firstOperand double
     * @return double negation of firstOperand
     */
    public double negationOperation(double firstOperand);
}
