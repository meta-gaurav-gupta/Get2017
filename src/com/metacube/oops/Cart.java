package com.metacube.oops;

import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class Cart {
    public ArrayList<Product> listOfProducts;

    /**
     * Constructor
     */
    public Cart() {
        listOfProducts = new ArrayList<>();
    }
    
    /**
     * Add Product To Cart
     * @param proudct New Product
     */
    public void addToCart(Product proudct){
        listOfProducts.add(proudct);
    } 
    
    /**
     * Get Product Information Of The Products Currently In The Cart
     * @return List Of ProductInfo
     */
    public ArrayList<ProductInfo> getCart(){
        ArrayList<ProductInfo> result = new ArrayList<>();
        ProductInfo info;
        for(Product product : listOfProducts){
            info = new ProductInfo();
            result.add(info.getProductInfo(product.getProductCode()));
        }
        return result;
    }
    
    /**
     * @param productId Integer
     * @return Product Quantity
     */
    public int getProductQuantity(int productId){
        int quantity = 0;
        for(Product product : listOfProducts){
            if(product.getProductCode() == productId){
                quantity = product.getProductQuantity();
                break;
            }
        }
        return quantity;
    }
    
}