
package com.metacube.oops;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaurav
 */
public class ReadCSV {
    private static final String PRODUCTS_FILE_PATH = ".\\src\\com\\metacube\\oops\\Products.csv";
    private static final String PRODUCT_PROMO_FILE_PATH = ".\\src\\com\\metacube\\oops\\ProductPromo.csv";
    private static final String ORDER_PROMO_FILE_PATH = ".\\src\\com\\metacube\\oops\\OrderPromo.csv";
    
    /**
     * Get Products From File
     * @return List of products
     */
    public static ArrayList<String> getProductsFromCSV(){
        ArrayList<String> data = new ArrayList<>();
        try {
            FileInputStream IS = new FileInputStream(PRODUCTS_FILE_PATH);
            BufferedReader BR = new BufferedReader(new InputStreamReader(IS));
            String line;
            while((line = BR.readLine()) != null){
                data.add(line); 
            } 
            IS.close();
            BR.close();
        } catch (IOException ex) {
                Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    /**
     * Get Products Promotions From File
     * @return List of promotions
     */
    public static ArrayList<Promotions> getProductPromoFromCSV(){
        ArrayList<Promotions> data = new ArrayList<>();
        try {
            FileInputStream IS = new FileInputStream(PRODUCT_PROMO_FILE_PATH);
            BufferedReader BR = new BufferedReader(new InputStreamReader(IS));
            String line;
            Promotions promotions =  null;
            while((line = BR.readLine()) != null){
                promotions = new Promotions(Promotions.PRODUCT_LEVEL_DISCOUNT);
                String[] attributes = line.split(",");
                if(attributes[0].contains("Amount")){
                    promotions.setPromotionType(Promotions.AMOUNT_DISCOUNT);
                }
                else if(attributes[0].contains("Percent")){
                    promotions.setPromotionType(Promotions.PERCENT_DISCOUNT);
                }
                promotions.setPromotionDiscount(Double.parseDouble(attributes[1]));
                String[] applicableIds = attributes[2].split(";");
                ArrayList<Integer> listOfIds = new ArrayList<>();
                for(String productIds : applicableIds){
                    listOfIds.add(Integer.parseInt(productIds));
                }
                promotions.setListOfProdcutIds(listOfIds);
                data.add(promotions);
            }
            IS.close();
            BR.close();
            
        } catch (IOException ex) {
                Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    /**
     * Get Order Promotions From File
     * @return List of promotions
     */
    public static ArrayList<Promotions> getOrderPromoFromCSV(){
        ArrayList<Promotions> data = new ArrayList<>();
        try {
            FileInputStream IS = new FileInputStream(ORDER_PROMO_FILE_PATH);
            BufferedReader BR = new BufferedReader(new InputStreamReader(IS));
            String line;
            Promotions promotions =  null;
            while((line = BR.readLine()) != null){
                promotions = new Promotions(Promotions.ORDER_LEVEL_DISCOUNT);
                String[] attributes = line.split(",");
                if(attributes[0].contains("Amount")){
                    promotions.setPromotionType(Promotions.AMOUNT_DISCOUNT);
                }
                else if(attributes[0].contains("Percent")){
                    promotions.setPromotionType(Promotions.PERCENT_DISCOUNT);
                }
                promotions.setPromotionDiscount(Double.parseDouble(attributes[1]));
                promotions.setMinOrderAmount(Double.parseDouble(attributes[2]));
                data.add(promotions);
            }
            
            IS.close();
            BR.close();
            
        } catch (IOException ex) {
                Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
