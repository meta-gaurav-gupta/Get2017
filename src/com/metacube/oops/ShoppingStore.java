package com.metacube.oops;

import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class ShoppingStore{
    
    /**
     * Display A Option Menu To Choose From The Given Options
     * Add to cart, show cart, exit
     */
    public void displayMenu(){
        Cart cart = new Cart();
        int productCode;
        int productQuantity;
        while(true){
            System.out.println("1. Add to cart.");
            System.out.println("2. Show cart.");
            System.out.println("3. Exit.");
            int choice = Utils.takeIntegerInput(1, 3);
            switch(choice){
                case 1:
                    productCode = Utils.inputValidProduct();
                    productQuantity = Utils.takeIntegerInput("Enter Product Quantitiy : ");
                    addProduct(cart, productCode, productQuantity);
                    break;
                case 2:
                    showCart(cart);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
    
    /**
     * Add To Cart 
     * @param cart Cart Instance
     * @param productCode Integer
     * @param productQuantity Integer
     */
    private void addProduct(Cart cart, int productCode, int productQuantity){
        Product product;
        product = new Product();
        product.setProductCode(productCode);
        product.setProductQuantity(productQuantity);
        cart.addToCart(product);
    }
    
    /**
     * Show Cart - Display Products In The Cart
     * @param cart Cart Instance
     */
    private void showCart(Cart cart){
        System.out.println("#####################################################\n" +
                           "YOUR ORDER :\n" +
                           "#####################################################\n");
        
        System.out.println("PURCHASED PRODUCTS :\n");
        double subTotal = 0;
        ArrayList<ProductInfo> listOfProductInfo = cart.getCart();
        for(ProductInfo product : listOfProductInfo){
            int productQuantity = cart.getProductQuantity(product.getProductId());
            subTotal += product.getProductPrice() * productQuantity;
            System.out.println("Product : " + product.getProductId() + " - " + product.getProductName());
            System.out.println(
                    "Cost: Rs." 
                            + productQuantity * product.getProductPrice() 
                            + "(" 
                            + productQuantity 
                            + " x "
                            + "Rs."
                            + product.getProductPrice()
                            + ")\n");
        }
        double productLevelDiscount = 0;
        System.out.println("\nAPPLIED PROMOTIONS/DISCOUNTS :\n");
        for(ProductInfo product : listOfProductInfo){
            System.out.print("Promotion : ");
            if(Promotions.AMOUNT_DISCOUNT.equals(product.getTypeOfPromotionApplied())){
                System.out.print("Rs." + product.getProductDiscount());
            }
            else if(Promotions.PERCENT_DISCOUNT.equals(product.getTypeOfPromotionApplied())){
                System.out.print(product.getPercentPromotion() + "%");
            }
            int productQuantity = cart.getProductQuantity(product.getProductId());
            System.out.print(" off on " + product.getProductName());
            productLevelDiscount += product.getProductDiscount() * productQuantity;
            System.out.println("\nDiscount : Rs." + product.getProductDiscount() * productQuantity);
        }
        double totalAmount = subTotal - productLevelDiscount;
        double orderLevelDiscount = Discount.getOrderLevelDiscount(totalAmount);
        double totalDiscount = productLevelDiscount + orderLevelDiscount;
        totalAmount -= totalDiscount;
        
        System.out.println("\nSubTotal : Rs." + subTotal);
        System.out.println("Product Level Discount : Rs." + productLevelDiscount);
        System.out.println("Order Level Discount : Rs." + orderLevelDiscount);
        System.out.println("Total Discounts : Rs." + totalDiscount);
        System.out.println("Total : Rs." + totalAmount);
        System.out.println("\n\n");
    }
}