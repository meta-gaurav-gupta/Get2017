
package com.metacube.oops;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gaurav
 */
public class Discount {
    
    /**
     * Calculate Product Level Discount
     * @param productId Integer
     * @param productPrice Double
     * @return The Maximum Discount 
     * HashMap - 
     * TYPE -> Type of promotion applied percent / amount
     * DISCOUNT -> Maximum discounted amount
     * PROMOTION -> If percentage promotion is applied percent discount is returned
     * 
     */
    public static HashMap<String, String> getProductLevelDiscount(int productId, double productPrice){
        double amountTypeDiscount = 0.0;
        double percentTypeDiscount = 0.0;
        ArrayList<Promotions> listOfPromotions = ReadCSV.getProductPromoFromCSV();
        double promotionDiscountPercent = 0;
        for(Promotions promotions : listOfPromotions){
            String promotionType = promotions.getPromotionType();
            if(Promotions.AMOUNT_DISCOUNT.equals(promotionType)){
                if(promotions.getListOfProdcutIds().contains(productId)){
                    if(amountTypeDiscount < promotions.getPromotionDiscount()){
                            amountTypeDiscount = promotions.getPromotionDiscount();
                        }
                }
            } else if(Promotions.PERCENT_DISCOUNT.equals(promotionType)){
                if(promotions.getListOfProdcutIds().contains(productId)){
                    double discount = productPrice * promotions.getPromotionDiscount() / 100;
                    if(percentTypeDiscount < discount){
                       promotionDiscountPercent = promotions.getPromotionDiscount();
                       percentTypeDiscount = discount;
                    }
                }
            }
        }
        HashMap<String, String> map = new HashMap<>();
        double maxDiscount = amountTypeDiscount > percentTypeDiscount ? amountTypeDiscount : percentTypeDiscount;
        map.put("TYPE", amountTypeDiscount > percentTypeDiscount? Promotions.AMOUNT_DISCOUNT : Promotions.PERCENT_DISCOUNT);
        map.put("DISCOUNT", maxDiscount + "");
        if(amountTypeDiscount < percentTypeDiscount){
            map.put("PROMOTION",promotionDiscountPercent + "");
        }
        return map;
    }
    
    /**
     * Get Order Level Discount
     * @param orderAmount double
     * @return double max discount on final order amount
     */
    public static double getOrderLevelDiscount(double orderAmount){
        double amountTypeDiscount = 0.0;
        double percentTypeDiscount = 0.0;
        ArrayList<Promotions> listOfPromotions = ReadCSV.getOrderPromoFromCSV();
        for(Promotions promotions : listOfPromotions){
            String promotionType = promotions.getPromotionType();
            if(Promotions.AMOUNT_DISCOUNT.equals(promotionType)){
                if(orderAmount >= promotions.getMinOrderAmount()){
                    if(amountTypeDiscount < promotions.getPromotionDiscount()){
                        amountTypeDiscount = promotions.getPromotionDiscount();
                    }
                }
            } else if(Promotions.PERCENT_DISCOUNT.equals(promotionType)){
                if(orderAmount >= promotions.getMinOrderAmount()){
                    double discount = orderAmount * promotions.getPromotionDiscount() / 100;
                    if(percentTypeDiscount < discount){
                        percentTypeDiscount = discount;
                    }
                }
            }
        }
        return amountTypeDiscount > percentTypeDiscount ? amountTypeDiscount : percentTypeDiscount;
    }
}
