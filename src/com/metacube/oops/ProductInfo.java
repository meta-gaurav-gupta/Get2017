
package com.metacube.oops;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gaurav
 */
public class ProductInfo {
    private int productId;
    private String productName;
    private double productPrice;
    private double productDiscount;
    private int productQuantity;
    private String typeOfPromotionApplied;
    private String percentPromotion;

    /**
     * Set Percent Discount
     * @param percentPromotion String
     */
    public void setPercentPromotion(String percentPromotion) {
        this.percentPromotion = percentPromotion;
    }

    /**
     * Get Percent Discount
     * @return String 
     */
    public String getPercentPromotion() {
        return percentPromotion;
    }

    /**
     * Set Type of promotion applied
     * @param typeOfPromotionApplied String
     */
    public void setTypeOfPromotionApplied(String typeOfPromotionApplied) {
        this.typeOfPromotionApplied = typeOfPromotionApplied;
    }

    /**
     * Get type of promotion applied
     * @return String
     */
    public String getTypeOfPromotionApplied() {
        return typeOfPromotionApplied;
    }
    
    /**
     * Set product quantity
     * @param productQuantity Integer
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * Get product quantity
     * @return Integer
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Get product id
     * @return Integer
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Set product id
     * @param productId Integer
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Set product name
     * @param productName String
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Set product price
     * @param productPrice
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * set product discount
     * @param productDiscount
     */
    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    /**
     * Get product name
     * @return String
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Get product price
     * @return double
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Get product discount
     * @return double
     */
    public double getProductDiscount() {
        return productDiscount;
    }
    
    /**
     * Get product info of supplied product id
     * @param productId Integer
     * @return Product Info 
     */
    public ProductInfo getProductInfo(int productId){
        ArrayList<String> listOfProducts = ReadCSV.getProductsFromCSV();
        ProductInfo productInfo = null;
        for(String product : listOfProducts){
            productInfo = new ProductInfo();
            String[] attributes = product.split(",");
            if(Integer.parseInt(attributes[0]) == productId){
                productInfo.setProductId(Integer.parseInt(attributes[0]));
                productInfo.setProductName(attributes[1]);
                productInfo.setProductPrice(Double.parseDouble(attributes[2]));
                break;
            }
        }
        if(productInfo.getProductId() == productId){
            HashMap<String, String> result = Discount.getProductLevelDiscount(productId, productInfo.getProductPrice());
            double discount = Double.parseDouble(result.get("DISCOUNT"));
            String typeOfPromotionApplied = result.get("TYPE");
            productInfo.setProductDiscount(discount);
            productInfo.setTypeOfPromotionApplied(typeOfPromotionApplied);
            productInfo.setPercentPromotion(result.get("PROMOTION"));
        }
        return productInfo;
    } 
}

