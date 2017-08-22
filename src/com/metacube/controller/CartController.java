package com.metacube.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.metacube.Facade.ProductFacade;
import com.metacube.entity.Product;
import com.metacube.entity.UserCart;


/**
 * The Class CartController.
 * 
 * This class controls the class related operation
 * 
 * @author Gaurav
 */
public class CartController {
	
    /** The product. */
    private Product product;

    /** The cart. */
    private UserCart cart;

    /** The user details. */
    private Map<String,Integer> userDetails;

    /** The pf. */
    ProductFacade pf=ProductFacade.getInstance();

    /**
     * Instantiates a new cart controller.
     */
    public CartController(){
        userDetails = new HashMap<>();
        cart = new UserCart();
    }

    /**
     * Adds the cart.
     *
     * @param id the id
     * @param quantity the quantity
     */
    public void addCart(String id,int quantity){
        if(userDetails.containsKey(id)){
            userDetails.put(id,userDetails.get(id) + quantity);
        } else {
            userDetails.put(id,quantity);
        }
        cart.setOrderDetail(userDetails);
    }

    /**
     * Prints the cart.
     */
    public void printCart(){
        if(userDetails.isEmpty()){
            System.out.println("Cart is empty!\n");
            return;
        }
        Set<String> keySet = userDetails.keySet();
        System.out.println("Items in your cart is: \n");
        System.out.println("Product Name \t Price \t Quantity \n");
        keySet.stream().map((id) -> {
            product = pf.getProduct(id);
            return id;
        }).forEachOrdered((id) -> {
            System.out.println(product.getName() + "\t " + product.getPrice() + "\t " + userDetails.get(id));
        });
        System.out.println("");
    }

    /**
     * Del cart.
     *
     * @param id the id
     * @param quantity the quantity
     * @return 
     */
    public boolean delCart(String id,int quantity){
        boolean result = false;
            /**Getting the quantity related to item**/
            if(userDetails.containsKey(id)){
                int updatedQuantity = userDetails.get(id) - quantity;
                if(updatedQuantity<=0){
                    /**If quantity becomes less than zero than remove the object from it**/
                    userDetails.remove(id);	
                } else {	
                    userDetails.put(id,updatedQuantity);
                }
                result = true;
            }
        return result;  
    }

    /**
     * Prints the bill.
     *
     * @return the total price
     */
    public double printBill(){
        /**Making the key set to iterate the keys**/
        Set<String> keySet = userDetails.keySet();
        Double totalPrice = 0.00;
        /**Calculating the total price **/
        for(String id : keySet){
            product = pf.getProduct(id);
            totalPrice += (product.getPrice() * userDetails.get(id));
        }
        /**Returning the total price**/
        return totalPrice;
    }

    public boolean isProductExists(String code){
        return userDetails.containsKey(code);
    }
}
