package com.metacube.oops;

/**
 *
 * @author Gaurav
 */
public class Product {
    private int productCode;
    private int productQuantity;

    /**
     * Get Product Code
     * @return Integer Product Code
     */
    public int getProductCode() {
        return productCode;
    }
    /**
     * Get Product Quantity
     * @return Integer Product Quantity
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Set Product Code
     * @param productCode Integer 
     */
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    /**
     * Set Product Quantity
     * @param productQuantity Integer 
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
