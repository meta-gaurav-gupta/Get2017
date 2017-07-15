package com.metacube.PF;

/**
 * PFAssignment1 - Convert Binary to Octal
 * @author Gaurav
 */
public class BinaryToOctal {
    /**
     * @param binaryNumber (Data Type - integer)
     * @return Octal Number (Data Type - integer)
     * Binary -> Decimal -> Octal
    */
    public int convertBinaryToOctal(int binaryNumber){
        int resultDecimal = convertBinaryToDecimal(binaryNumber);   // 
        int resultOctal = convertDecimalToOctal(resultDecimal);
        return resultOctal;
    }
    
    /**
     *  Method - convertBinaryToDecimal
     *  Parameters - Binary Number (Data Type - integer)
     *  Return - Decimal Number (Data Type - integer)
     *  Binary -> Decimal
     * @param binaryNumber
     * @return 
    */
    
    public int convertBinaryToDecimal(int binaryNumber){
        int decimalNumber = 0;
        for ( int binaryMultiplier = 1 ; binaryNumber != 0 ; binaryMultiplier = binaryMultiplier*2, binaryNumber /= 10){
            decimalNumber += (binaryNumber % 10) * binaryMultiplier;
        }
        
        return decimalNumber;
    }  
    
    /**
     *  Method - convertDecimalToOctal
     *  Parameters - Decimal Number (Data Type - integer)
     *  Return - Decimal Number (Data Type - integer)
     *  Decimal -> Octal
     * @param decimalNumber
     * @return 
    */
    
    public int convertDecimalToOctal(int decimalNumber) {
        int octalAnswer = 0;
        for (int octalMultiplier = 0, decimalRemainder = 0 ; decimalNumber != 0 ; decimalNumber /= 8,octalMultiplier++) {
            decimalRemainder = decimalNumber % 8;
            octalAnswer += decimalRemainder * Math.pow(10,octalMultiplier);
        }
        
        return octalAnswer;
    }
}
