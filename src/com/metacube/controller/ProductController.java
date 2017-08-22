package com.metacube.controller;

import com.metacube.Facade.ProductFacade;
import com.metacube.entity.Product;
import com.metacube.enums.Status;
import java.util.HashMap;



/**
 * The Class ProductController.
 * 
 * Control the product related operations
 * 
 * @author Gaurav
 */
public class ProductController {
	
	
    /** The pf. object of product facade class */
    ProductFacade pf;


    /**
     * Instantiates a new product controller.
     */
    public ProductController() {
        pf = ProductFacade.getInstance();
    }


    /**
     * Search product.
     *
     *This method search the product if it is present or not
     *
     * @param id the id
     * @return the status
     */
    public Status searchProduct(String id){
        return pf.searchproduct(id);
    }


    /**
     * Prints the product.
     * 
     * This method print all the product to console
     * @return 
     */
    public HashMap<String,Product> getAllProduct(){
        return pf.getAllProduct();
    }
    
}


