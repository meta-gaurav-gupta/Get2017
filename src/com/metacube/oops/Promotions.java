
package com.metacube.oops;

import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class Promotions {
    public static final String AMOUNT_DISCOUNT = "Amount";
    public static final String PERCENT_DISCOUNT = "Percent";
    public static final String PRODUCT_LEVEL_DISCOUNT = "Product";
    public static final String ORDER_LEVEL_DISCOUNT = "Order";
    
    private String promotionType;
    private double promotionDiscount;
    private double minOrderAmount;
    private ArrayList<Integer> listOfProdcutIds;
    
    /**
     * Set Minimum Order Amount
     * @param minOrderAmount double
     */
    public void setMinOrderAmount(double minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    /**
     * Get Minimum Order Amount
     * @return double
     */
    public double getMinOrderAmount() {
        return minOrderAmount;
    }
    
    /**
     * Constructor
     * @param levelTypeDiscount String
     */
    public Promotions(String levelTypeDiscount) {
        if(PRODUCT_LEVEL_DISCOUNT.equals(levelTypeDiscount)){
            listOfProdcutIds = new ArrayList<>();
        }
    }
    
    /**
     * Get Promotion Type
     * @return String
     */
    public String getPromotionType() {
        return promotionType;
    }

    /**
     * Get Promotion Discount
     * @return double
     */
    public double getPromotionDiscount() {
        return promotionDiscount;
    }
    
    /**
     * Get List Of Product Ids
     * @return List Of Product Ids
     */
    public ArrayList<Integer> getListOfProdcutIds() {
        return listOfProdcutIds;
    }
    
    /**
     * Set Promotion Type
     * @param promotionType String 
     */
    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    /**
     * Set Promotion Discount
     * @param promotionDiscount double 
     */
    public void setPromotionDiscount(double promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    /**
     * Set List Of ProductIds
     * @param listOfProdcutIds List of product ids 
     */
    public void setListOfProdcutIds(ArrayList<Integer> listOfProdcutIds) {
        this.listOfProdcutIds = listOfProdcutIds;
    }
    
}
